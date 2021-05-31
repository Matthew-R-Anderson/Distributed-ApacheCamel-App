/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creator;

import domain.Customer;

/**
 *
 * @author mattanderson
 */
public class UpdateCustomerGroup {
    
    public Customer updateGroup(String id, String firstName, String lastName, String email){
        
        Customer cust = new Customer();
        cust.setId(id);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        cust.setGroup("0afa8de1-147c-11e8-edec-201e0f00872c");
        cust.setEmail(email);
        
        return cust;
    }
}
