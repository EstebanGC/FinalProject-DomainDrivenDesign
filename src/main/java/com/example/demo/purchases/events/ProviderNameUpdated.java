package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.ProviderId;

public class ProviderNameUpdated extends DomainEvent {

    private final ProviderId providerId;
    private final Name name;

    public ProviderNameUpdated(ProviderId providerId, Name name){
        super("sofka.provider.providernameupdated");
        this.providerId = providerId;
        this.name = name;
    }

    public ProviderId getProviderId(){
        return providerId;
    }

    public Name getName() {
        return name;
    }

}
