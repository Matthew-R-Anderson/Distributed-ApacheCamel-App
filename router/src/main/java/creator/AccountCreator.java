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
public class AccountCreator {
    
    public Account createAccount(Customer customer) {
        
        Account acc = new Account();
        
        acc.setId(customer.getId());
        acc.setUsername(customer.getCustomerCode());
        acc.setFirstName(customer.getFirstName());
        acc.setLastName(customer.getLastName());
        acc.setGroup(customer.getGroup());
        acc.setEmail(customer.getEmail());
        
        return acc;
        
    }
    
}
