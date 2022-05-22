package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.PurchaseId;

public class AddPurchase extends Command {

    private final PurchaseId purchaseId;

    public AddPurchase(PurchaseId purchaseId){
        this.purchaseId = purchaseId;
    }
     public PurchaseId getPurchaseId() {
        return purchaseId;
     }

}
