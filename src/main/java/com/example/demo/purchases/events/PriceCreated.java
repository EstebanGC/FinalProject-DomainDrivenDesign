package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Price;
import com.example.demo.purchases.values.PurchaseId;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;

public class PriceCreated extends DomainEvent {

    private final PurchasingBookId purchasingBookId;
    private final PurchasedBookId purchasedBookId;
    private final Price price;

    public PriceCreated(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Price price){
        super("sofka.price.pricecreated");
        this.purchasingBookId = purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.price = price;
    }

    public PurchasingBookId getPurchasingBookId(){ return purchasingBookId;}

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }

    public Price getPrice(){
        return price;
    }
}
