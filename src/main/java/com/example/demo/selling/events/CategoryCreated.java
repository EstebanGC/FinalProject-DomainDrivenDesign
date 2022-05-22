package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.Category;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;

public class CategoryCreated extends DomainEvent {
    private final Category category;
    private final SellingBookId sellingBookId;
    private final SellingId sellingId;

    public CategoryCreated(SellingBookId sellingBookId, SellingId sellingId, Category category){
        super("sofka.category.categorycreated");
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.category = category;

    }

    public SellingBookId getSellingBookId() {return sellingBookId;}
    public SellingId getSellingId(){ return sellingId;}
    public Category getCategory(){
        return category;
    }

}
