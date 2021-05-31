/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import creator.AccountCreator;
import creator.GroupCheckerUpdater;
import creator.UpdateCustomerGroup;
import domain.Sale;
import domain.Summary;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 *
 * @author mattanderson
 */
public class SaleBuilder extends RouteBuilder {

    @Override
    public void configure() {

//        Fethes the sale from SSE bridge, from JMS queue
        from("jms:queue:new-sale")
                .convertBodyTo(String.class)
                .log("${body}")
                .to("jms:queue:new-vend-sale");

//        Sale object creation, setting properties, formatting sale
        from("jms:queue:new-vend-sale")
                .unmarshal().json(JsonLibrary.Gson, Sale.class)
                .log("${body}")
                .setProperty("Customer_Id").simple("${body.customer.id}")
                .setProperty("Customer_Group").simple("${body.customer.group}")
                .setProperty("Customer_Email").simple("${body.customer.email}")
                .setProperty("Customer_FirstName").simple("${body.customer.firstName}")
                .setProperty("Customer_LastName").simple("${body.customer.lastName}")
                .removeHeaders("*")
                .marshal().json(JsonLibrary.Gson)
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .to("http://localhost:8081/api/sales")
                .to("jms:queue:get-sale-summary");

//        Get Sale summary for customer from sale service
        from("jms:queue:get-sale-summary")
                .removeHeaders("*")
                .setBody(constant(null))
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .recipientList()
                .simple("http://localhost:8081/api/sales/customer/${exchangeProperty.Customer_Id}/summary")
                .log("${body}")
                .to("jms:queue:sale-summary-response");

//        Look to see if the customer group needs to be changed using GroupCheckerUpdater class
//        Sends to 2 different queues depending on if customer group needs to be changed       
        from("jms:queue:sale-summary-response")
                .unmarshal().json(JsonLibrary.Gson, Summary.class)
                .log("${body}")
                .bean(GroupCheckerUpdater.class, "groupChanger(${body})")
                .choice()
                    .when().simple("${body.group} == ${exchangeProperty.Customer_Group}")
                        .log("Update Group Not Needed: ${body.group} does not equal ${exchangeProperty.Customer_Group}")
                        .to("jms:queue:no-group-update")
                .otherwise()
                        .log("Update Group Needed: ${body.group} does not equal ${exchangeProperty.Customer_Group}")
                        .to("jms:queue:update-customer-group");

//        Updating customers group to VIP
//        Sends to vend and account service via puts
        from("jms:update-customer-group")
                .log("${body}")
                .bean(UpdateCustomerGroup.class, "updateGroup(${exchangeProperty.Customer_Id},"
                        + "${exchangeProperty.Customer_FirstName}, "
                        + "${exchangeProperty.Customer_LastName}, "
                        + "${exchangeProperty.Customer_Email})")
                .multicast()
                .to("jms:queue:vend-put", "jms:queue:accounts-service-put");

//    Sends a PUT request to the accounts service to change customers group
        from("jms:queue:accounts-service-put")
                .bean(AccountCreator.class, "createAccount(${body})")
                .log("${body}")
                .marshal().json(JsonLibrary.Gson)
                .removeHeaders("*")
                .setHeader(Exchange.CONTENT_TYPE).constant("application/json")
                // set HTTP method
                .setHeader(Exchange.HTTP_METHOD, constant("PUT"))
                .recipientList()
                .simple("http://localhost:8086/api/accounts/account/${exchangeProperty.Customer_Id}")
                .to("jms:queue:accounts-service-updated-response");

        from("jms:queue:vend-put")
                .log("${body}")
                // remove headers so they don't get sent to Vend
                .removeHeaders("*")
                // add authentication token to authorization header
                .setHeader("Authorization", constant("Bearer KiQSsELLtocyS2WDN5w5s_jYaBpXa0h2ex1mep1a"))
                // marshal to JSON
                .marshal().json(JsonLibrary.Gson) // only necessary if the message is an object, not JSON
                .setHeader(Exchange.CONTENT_TYPE).constant("application/json")
                // set HTTP method
                .setHeader(Exchange.HTTP_METHOD, constant("PUT"))
                .recipientList()
                    .simple("https://info303otago.vendhq.com/api/2.0/customers/${exchangeProperty.Customer_Id}")
                .to("jms:queue:vend-customer-updated-response");
    }
}
