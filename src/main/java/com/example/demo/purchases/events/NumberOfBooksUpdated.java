package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchaseId;
import com.example.demo.purchases.values.PurchasingBookId;

public class NumberOfBooksUpdated extends DomainEvent {

    private final PurchasingBookId purchasingBookId;
    private final PurchaseId purchaseId;
    private final NumberOfBooks numberOfBooks;

    public NumberOfBooksUpdated(PurchasingBookId purchasingBookId, PurchaseId purchaseId, NumberOfBooks numberOfBooks){
        super("sofka.numberofbooks.numberofbooksupdated");
        this.purchasingBookId = purchasingBookId;
        this.purchaseId = purchaseId;
        this.numberOfBooks = numberOfBooks;
    }

    public PurchasingBookId getPurchasingBookId() { return purchasingBookId; }

    public PurchaseId getPurchaseId() {
        return purchaseId;
    }

    public NumberOfBooks getNumberOfBooks() {
        return numberOfBooks;
    }


}
