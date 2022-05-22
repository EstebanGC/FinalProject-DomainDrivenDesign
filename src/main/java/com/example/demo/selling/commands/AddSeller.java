package com.example.demo.selling.commands;

import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellerId;
import com.example.demo.selling.values.SoldBooks;

public class AddSeller {

    private final SellerId sellerId;
    private final Name name;
    private final SoldBooks soldBooks;

    public AddSeller(SellerId sellerId,Name name,SoldBooks soldBooks) {
        this.sellerId = sellerId;
        this.name = name;
        this.soldBooks = soldBooks;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public Name getName(){
        return name;
    }

    public SoldBooks getSoldBooks() {
        return soldBooks;
    }
}
