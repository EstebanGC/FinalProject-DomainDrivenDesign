package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.ProviderId;

public class ProviderCreated extends DomainEvent {

    private final ProviderId providerId;

    public ProviderCreated(ProviderId providerId) {
        super("sofka.provider.providercreated");
        this.providerId = providerId;
    }

    public ProviderId getProviderId(){
        return providerId;
    }
}
