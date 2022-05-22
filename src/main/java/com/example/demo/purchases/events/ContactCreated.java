package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Category;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasedBookId;

public class ContactCreated extends DomainEvent {
    private final ProviderId providerId;

    public ContactCreated(ProviderId providerId){
        super("sofka.contact.contactcreated");
        this.providerId = providerId;
    }

    public ProviderId providerId(){ return providerId;}

}
