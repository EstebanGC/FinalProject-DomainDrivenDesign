package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.PurchasedBookId;

public class PurchasedBookNameUpdated extends DomainEvent {

    private final PurchasedBookId purchasedBookId;
    private final Name name;

    public PurchasedBookNameUpdated(PurchasedBookId purchasedBookId, Name name) {
        super("sofka.purchasedbook.purchasedbookupdated");
        this.purchasedBookId = purchasedBookId;
        this.name = name;
    }

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }

    public Name getName() {
        return name;
    }
}
