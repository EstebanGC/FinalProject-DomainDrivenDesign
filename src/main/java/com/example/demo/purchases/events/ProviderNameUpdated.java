package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasingBookId;

public class ProviderNameUpdated extends DomainEvent {

    private final PurchasingBookId purchasingBookId;
    private final ProviderId providerId;
    private final Name name;

    public ProviderNameUpdated(PurchasingBookId purchasingBookId, ProviderId providerId, Name name){
        super("sofka.provider.providernameupdated");
        this.purchasingBookId = purchasingBookId;
        this.providerId = providerId;
        this.name = name;
    }

    public PurchasingBookId getPurchasingBookId() { return purchasingBookId; }

    public ProviderId getProviderId(){
        return providerId;
    }

    public Name getName() {
        return name;
    }

}
