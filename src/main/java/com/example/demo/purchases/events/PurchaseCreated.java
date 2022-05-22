package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.PurchaseId;

public class PurchaseCreated extends DomainEvent {
    private final PurchaseId purchaseId;

    public PurchaseCreated(PurchaseId purchaseId) {
        super("sofka.purchase.purchasecreated");
        this.purchaseId = purchaseId;
    }

    public PurchaseId getPurchaseId(){
        return purchaseId;
    }
}
