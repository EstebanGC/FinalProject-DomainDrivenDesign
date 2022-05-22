package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.BookStore;
import com.example.demo.selling.values.Category;
import com.example.demo.selling.values.Price;

public class SellingBookCreated extends DomainEvent {

    private final BookStore bookStore;

    public SellingBookCreated(BookStore bookStore){
        super("sofka.sellingbook.sellingbookcreated");
        this.bookStore = bookStore;
    }
    public BookStore getBookStore() {
        return bookStore;
    }
}
