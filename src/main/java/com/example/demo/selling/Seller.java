package com.example.demo.selling;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.example.demo.selling.values.*;

import java.util.Objects;

public class Seller extends Entity<SellerId> {
    private SellerId sellerId;
    private Name name;
    private SoldBooks soldBooks;

    public Seller(SellerId sellerId, Name name, SoldBooks soldBooks) {
        super(sellerId);
        this.name = name;
        this.soldBooks = soldBooks;
    }

    public Seller(SellerId sellerId){
        super(sellerId);
    }

    public void updateSellerName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updateSoldBooks(SoldBooks soldBooks){
        this.soldBooks = Objects.requireNonNull(soldBooks);
    }

    public Name getName() {
        return name;
    }

    public SoldBooks getSoldBooks() {
        return soldBooks;
    }
}
