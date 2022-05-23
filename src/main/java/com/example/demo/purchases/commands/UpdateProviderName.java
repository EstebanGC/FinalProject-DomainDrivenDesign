package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.selling.values.Name;

public class UpdateProviderName {
    private final Name name;

    public UpdateProviderName(PurchasingBookId purchasingBookId, Name name){
        this.name=name;
    }

    public Name getName() {
        return name;
    }
}
