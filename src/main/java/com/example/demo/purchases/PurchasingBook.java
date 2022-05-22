package com.example.demo.purchases;

import co.com.sofka.domain.generic.AggregateEvent;
import com.example.demo.purchases.values.BookStore;
import com.example.demo.purchases.values.PurchasingBookId;

public class PurchasingBook extends AggregateEvent<PurchasingBookId> {
    public PurchasingBook(PurchasingBookId purchasingBookIdId, BookStore bookStore) {
        super(purchasingBookIdId);
    }
}
