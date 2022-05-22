package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchaseId;

public class NumberOfBooksUpdated extends DomainEvent {

    private final PurchaseId purchaseId;
    private final NumberOfBooks numberOfBooks;

    public NumberOfBooksUpdated(PurchaseId purchaseId, NumberOfBooks numberOfBooks){
        super("sofka.numberofbooks.numberofbooksupdated");
        this.purchaseId = purchaseId;
        this.numberOfBooks = numberOfBooks;
    }

    public PurchaseId getPurchaseId() {
        return purchaseId;
    }

    public NumberOfBooks getNumberOfBooks() {
        return numberOfBooks;
    }


}
