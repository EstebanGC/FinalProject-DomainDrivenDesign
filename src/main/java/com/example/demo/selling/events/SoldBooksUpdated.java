package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.SellerId;
import com.example.demo.selling.values.SoldBooks;

public class SoldBooksUpdated extends DomainEvent {

    private final SellerId sellerId;
    private final SoldBooks soldBooks;

    public SoldBooksUpdated(SellerId sellerId, SoldBooks soldBooks) {
        super("sofka.soldbooks.soldbookscreated");
        this.sellerId = sellerId;
        this.soldBooks = soldBooks;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public SoldBooks getSoldBooks(){
        return soldBooks;
    }
}

