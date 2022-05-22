package com.example.demo.purchases.commands;

import com.example.demo.selling.values.Name;

public class UpdateProviderName {
    private final Name name;

    public UpdateProviderName(Name name){
        this.name=name;
    }

    public Name getName() {
        return name;
    }
}
