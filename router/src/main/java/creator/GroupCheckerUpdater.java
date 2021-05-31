/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creator;

import domain.Summary;

/**
 *
 * @author mattanderson
 */
public class GroupCheckerUpdater {
    
    public Summary groupChanger(Summary summary){
        Summary summarys = new Summary();
        
        summarys.setNumberOfSales(summary.getNumberOfSales());
        summarys.setTotalPayment(summary.getTotalPayment());
        
        if(summary.getGroup().equals("Regular Customers")){
            summarys.setGroup("0afa8de1-147c-11e8-edec-2b197906d816");
        } else {
            summarys.setGroup("0afa8de1-147c-11e8-edec-201e0f00872c");
        }
        
        return summarys;
        
    }
    
}
