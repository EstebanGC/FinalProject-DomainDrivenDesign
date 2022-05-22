package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Price;
import com.example.demo.purchases.values.PurchaseId;

public class PriceCreated extends DomainEvent {

    private final PurchaseId purchaseId;
    private final Price price;

    public PriceCreated(PurchaseId purchaseId, Price price){
        super("sofka.price.pricecreated");
        this.purchaseId = purchaseId;
        this.price = price;
    }

    public PurchaseId getPurchaseId(){
        return purchaseId;
    }

    public Price getPrice(){
        return price;
    }
}
