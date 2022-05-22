package com.example.demo.purchases.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.values.Category;
import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasedBookId;

public class ContactCreated extends DomainEvent {
    private final ProviderId providerId;
    private final Contact contact;

    public ContactCreated(ProviderId providerId, Contact contact){
        super("sofka.contact.contactcreated");
        this.providerId = providerId;
        this.contact = contact;
    }

    public ProviderId getProviderId(){ return providerId;}

    public Contact getContact() {
        return contact;
    }
}
