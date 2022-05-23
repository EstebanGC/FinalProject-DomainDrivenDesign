package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.*;

public class ContactCreated extends DomainEvent {
    private final PurchasingBookId purchasingBookId;
    private final ProviderId providerId;
    private final Contact contact;

    public ContactCreated(PurchasingBookId purchasingBookId, ProviderId providerId, Contact contact){
        super("sofka.contact.contactcreated");
        this.purchasingBookId = purchasingBookId;
        this.providerId = providerId;
        this.contact = contact;
    }

    public PurchasingBookId getPurchasingBookId(){ return purchasingBookId;}

    public ProviderId getProviderId(){ return providerId;}

    public Contact getContact() {
        return contact;
    }
}
