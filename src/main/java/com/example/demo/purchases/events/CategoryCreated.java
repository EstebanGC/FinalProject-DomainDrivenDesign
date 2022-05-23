package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Category;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;

public class CategoryCreated extends DomainEvent {
    private final PurchasingBookId purchasingBookId;
    private final PurchasedBookId purchasedBookId;
    private final Category category;

    public CategoryCreated(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Category category){
        super("sofka.category.categorycreated");
        this.purchasingBookId = purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.category = category;
    }

    public PurchasingBookId getPurchasingBookId() { return purchasingBookId; }
    public PurchasedBookId getPurchasedBookId(){ return purchasedBookId;}
    public Category getCategory(){
        return category;
    }
}
