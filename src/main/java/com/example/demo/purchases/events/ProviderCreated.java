package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasingBookId;

public class ProviderCreated extends DomainEvent {

    private final PurchasingBookId purchasingBookId;
    private final ProviderId providerId;
    private final Name name;
    private final Contact contact;

    public ProviderCreated(PurchasingBookId purchasingBookId, ProviderId providerId, Name name, Contact contact) {
        super("sofka.provider.providercreated");
        this.purchasingBookId = purchasingBookId;
        this.providerId = providerId;
        this.name = name;
        this.contact = contact;
    }

    public PurchasingBookId getPurchasingBookId(){ return purchasingBookId;}

    public ProviderId getProviderId(){
        return providerId;
    }

    public Name getName() { return name;}

    public Contact getContact() { return contact;}
}
