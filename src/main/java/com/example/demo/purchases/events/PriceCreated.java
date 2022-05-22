package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Price;
import com.example.demo.purchases.values.PurchaseId;
import com.example.demo.purchases.values.PurchasedBookId;

public class PriceCreated extends DomainEvent {

    private final PurchasedBookId purchasedBookId;
    private final Price price;

    public PriceCreated(PurchasedBookId purchasedBookId, Price price){
        super("sofka.price.pricecreated");
        this.purchasedBookId = purchasedBookId;
        this.price = price;
    }

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }

    public Price getPrice(){
        return price;
    }
}
