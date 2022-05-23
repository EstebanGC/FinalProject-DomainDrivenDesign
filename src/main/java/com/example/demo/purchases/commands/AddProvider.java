package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.selling.values.Name;

public class AddProvider {
    private final PurchasingBookId purchasingBookId;
    private final ProviderId providerId;
    private final Name name;


    public AddProvider(PurchasingBookId purchasingBookId, ProviderId providerId, Name name) {
        this.purchasingBookId = purchasingBookId;
        this.providerId = providerId;
        this.name = name;
    }

    public PurchasingBookId getPurchasingBookId(){
        return purchasingBookId;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Name getName(){
        return name;
    }
}
