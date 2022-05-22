package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchaseId;
import com.example.demo.purchases.values.TotalPrice;

public class PurchaseCreated extends DomainEvent {
    private final PurchaseId purchaseId;
    private final NumberOfBooks numberOfBooks;
    private final TotalPrice totalPrice;

    public PurchaseCreated(PurchaseId purchaseId, NumberOfBooks numberOfBooks, TotalPrice totalPrice) {
        super("sofka.purchase.purchasecreated");
        this.purchaseId = purchaseId;
        this.numberOfBooks = numberOfBooks;
        this.totalPrice = totalPrice;
    }

    public PurchaseId getPurchaseId(){
        return purchaseId;
    }

    public NumberOfBooks getNumberOfBooks(){
        return numberOfBooks;
    }

    public TotalPrice getTotalPrice(){
        return totalPrice;
    }
}
