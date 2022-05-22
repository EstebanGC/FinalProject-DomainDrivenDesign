package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Category;
import com.example.demo.purchases.values.PurchasedBookId;

public class CategoryCreated extends DomainEvent {
    private final Category category;
    private final PurchasedBookId purchasedBookId;

    public CategoryCreated(PurchasedBookId purchasedBookId, Category category){
        super("sofka.category.categorycreated");
        this.purchasedBookId = purchasedBookId;
        this.category = category;

    }

    public PurchasedBookId getPurchasedBookId(){ return purchasedBookId;}
    public Category getCategory(){
        return category;
    }
}
