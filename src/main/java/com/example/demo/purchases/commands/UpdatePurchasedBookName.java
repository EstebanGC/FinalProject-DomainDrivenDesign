package com.example.demo.purchases.commands;

import com.example.demo.selling.values.Name;

public class UpdatePurchasedBookName {
    private final Name name;

    public UpdatePurchasedBookName(Name name){
        this.name=name;
    }

    public Name getName() {
        return name;
    }
}
