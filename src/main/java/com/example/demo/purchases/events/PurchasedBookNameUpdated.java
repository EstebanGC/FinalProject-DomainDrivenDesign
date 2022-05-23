package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;

public class PurchasedBookNameUpdated extends DomainEvent {

    private final PurchasingBookId purchasingBookId ;
    private final PurchasedBookId purchasedBookId;
    private final Name name;

    public PurchasedBookNameUpdated(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Name name) {
        super("sofka.purchasedbook.purchasedbookupdated");
        this.purchasingBookId = purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.name = name;
    }

    public PurchasingBookId getPurchasingBookId(){ return purchasingBookId;}

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }

    public Name getName() {
        return name;
    }
}
