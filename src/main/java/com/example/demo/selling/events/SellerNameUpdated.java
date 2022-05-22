package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellerId;

public class SellerNameUpdated extends DomainEvent {
    private final SellerId sellerId;
    private final Name name;

    public SellerNameUpdated(SellerId sellerId, Name name) {
        super("sofka.name.nameupdated");
        this.sellerId = sellerId;
        this.name=name;
    }

    public Name getName(){
        return name;
    }

    public SellerId getSellerId() {
        return sellerId;
    }
}
