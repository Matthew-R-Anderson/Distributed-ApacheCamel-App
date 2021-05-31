/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import creator.AccountCreator;
import creator.CustomerCreator;
import domain.Account;
import domain.Customer;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 *
 * @author mattanderson
 */
public class CustomerBuilder extends RouteBuilder {

    @Override
    public void configure() {

//        Creates initial endpoint from HTTP
        from("jetty:http://localhost:9000/customercreateaccount?enableCORS=true")
                .setExchangePattern(ExchangePattern.InOnly)
                .log("${body}")
                .unmarshal().json(JsonLibrary.Gson, Account.class)
                .to("jms:queue:create-account");

//        Converting into the customer object
        from("jms:queue:create-account")
                .bean(CustomerCreator.class, "createCustomer(${body})")
                .to("jms:queue:vend-send");

//        Converts customer object and sends JSON to Vend
        from("jms:queue:vend-send")
                .removeHeaders("*")
                .setHeader("Authorization", constant("Bearer KiQSsELLtocyS2WDN5w5s_jYaBpXa0h2ex1mep1a"))
                .marshal().json(JsonLibrary.Gson)
                .setHeader(Exchange.CONTENT_TYPE).constant("application/json")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .to("https://info303otago.vendhq.com/api/2.0/customers")
                .to("jms:queue:vend-response");

//        Converts the Customer response from vend and makes it back into Account object
        from("jms:queue:vend-response")
                .setBody().jsonpath("$.data")
                .marshal().json(JsonLibrary.Gson)
                .unmarshal().json(JsonLibrary.Gson, Customer.class)
                .bean(AccountCreator.class, "createAccount(${body})")
                .marshal().json(JsonLibrary.Gson)
                .to("jms:queue:account");

        from("jms:queue:account")
                .removeHeaders("*")
                .setHeader(Exchange.CONTENT_TYPE).constant("application/json")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .to("http://localhost:8086/api/accounts");
    }

}
