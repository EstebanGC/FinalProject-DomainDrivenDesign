package com.example.demo.selling.commands;

import com.example.demo.selling.values.Name;

public class UpdateSellerName {
    private final Name name;

    public UpdateSellerName(Name name) {
        this.name=name;
    }
    public Name getName(){
        return name;
    }
}
