package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.BookStore;
import com.example.demo.purchases.values.PurchasingBookId;

public class PurchasingBookCreated extends DomainEvent {

    private final PurchasingBookId purchasingBookId;
    private final BookStore bookStore;

    public PurchasingBookCreated(PurchasingBookId purchasingBookId, BookStore bookStore){
        super("sofka.purchasingbook.purchasingbookcreated");
        this.purchasingBookId = purchasingBookId;
        this.bookStore = bookStore;
    }

    public PurchasingBookId getPurchasingBookId() {
        return purchasingBookId;
    }
    public BookStore getBookStore() { return bookStore;
    }
}
