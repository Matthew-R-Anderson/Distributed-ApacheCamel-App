/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creator;

import domain.Account;
import domain.Customer;

/**
 *
 * @author mattanderson
 */
public class CustomerCreator {
    
//    For regular customers
    
    public Customer createCustomer(Account account) {
            
            Customer cust = new Customer();
            
            cust.setGroup("0afa8de1-147c-11e8-edec-2b197906d816");
            cust.setCustomerCode(account.getUsername());
            cust.setFirstName(account.getFirstName());
            cust.setLastName(account.getLastName());
            cust.setEmail(account.getEmail());
            
            
            return cust;
        }
    
    
}
