package com.example.demo.purchases;

import co.com.sofka.domain.generic.Entity;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.ProviderId;

import java.util.Objects;

public class Provider extends Entity<ProviderId> {

    private ProviderId providerId;
    private Name name;

    public Provider(ProviderId providerId, Name name) {
        super(providerId);
        this.providerId = providerId;
        this.name = name;
    }

    public Provider(ProviderId providerId){
        super(providerId);
    }
    public void updateProviderName(Name name) {
        this.name= Objects.requireNonNull(name);
    }

    public ProviderId getProviderId(){
        return providerId;
    }

    public Name getName(){
        return name;
    }
}
