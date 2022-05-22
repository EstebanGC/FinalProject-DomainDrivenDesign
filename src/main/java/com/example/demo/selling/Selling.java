package com.example.demo.selling;

import co.com.sofka.domain.generic.Entity;
import com.example.demo.selling.values.*;

import java.util.Objects;

public class Selling extends Entity<SellingId> {

    private Category category;
    private Name name;
    private Price price;

    public Selling(SellingId sellingId, Category category, Name name, Price price) {
        super(sellingId);
        this.category = category;
        this.name= name;
        this.price = price;
    }

    public Selling(SellingId sellingId) {
        super(sellingId);
    }

    public void addPrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }

    public void addCategory(Category category){
        this.category = Objects.requireNonNull(category);
    }

    public Category getCategory() {
        return category;
    }

    public Price getPrice() {
        return price;
    }

    public Name updateName(Name name) { return name;
    }
}
