package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.PurchasingBookId;

public class PurchasingBookCreated extends DomainEvent {

    private final PurchasingBookId purchasingBookId;

    public PurchasingBookCreated(PurchasingBookId purchasingBookId){
        super("sofka.purchasingbook.purchasingbookcreated");
        this.purchasingBookId = purchasingBookId;
    }

    public PurchasingBookId getPurchasingBookId() {
        return purchasingBookId;
    }
}
