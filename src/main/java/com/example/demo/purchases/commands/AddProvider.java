package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.ProviderId;
import com.example.demo.selling.values.Name;

public class AddProvider {
    private final ProviderId providerId;
    private final Name name;


    public AddProvider(ProviderId providerId, Name name) {
        this.providerId = providerId;
        this.name = name;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Name getName(){
        return name;
    }
}
