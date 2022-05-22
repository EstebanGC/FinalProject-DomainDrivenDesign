package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.BookStore;
import com.example.demo.selling.values.Category;
import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingBookId;

public class SellingBookCreated extends DomainEvent {

    private final SellingBookId sellingBookId;
    private final BookStore bookStore;

    public SellingBookCreated(SellingBookId sellingBookId, BookStore bookStore){
        super("sofka.sellingbook.sellingbookcreated");
        this.sellingBookId = sellingBookId;
        this.bookStore = bookStore;
    }

    public SellingBookId getSellingBookId() {return sellingBookId;}
    public BookStore getBookStore() {
        return bookStore;
    }
}
