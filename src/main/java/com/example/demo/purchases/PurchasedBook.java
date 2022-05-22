package com.example.demo.purchases;

import co.com.sofka.domain.generic.Entity;
import com.example.demo.purchases.values.*;

import java.util.Objects;

public class PurchasedBook extends Entity<PurchasedBookId> {

    private Category category;
    private Name name;
    private Price price;

    public PurchasedBook(PurchasedBookId purchasedBookId, Category category, Name name, Price price){
        super(purchasedBookId);
        this.category =category;
        this.name= name;
        this.price = price;
    }

    public PurchasedBook(PurchasedBookId purchasedBookId){
        super(purchasedBookId);
    }

    public void addPrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }

    public void addCategory(Category category) {
        this.category = Objects.requireNonNull(category);
    }

    public void updateBookName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public Category getCategory(){
        return category;
    }

    public Price getPrice(){
        return price;
    }

    public Name getName() { return name;}


}
