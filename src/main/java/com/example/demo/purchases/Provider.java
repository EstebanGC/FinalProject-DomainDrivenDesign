package com.example.demo.purchases;

import co.com.sofka.domain.generic.Entity;
import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.Name;
import com.example.demo.purchases.values.ProviderId;

import java.util.Objects;

public class Provider extends Entity<ProviderId> {

    private ProviderId providerId;
    private Name name;
    private Contact contact;

    public Provider(ProviderId providerId, Name name, Contact contact) {
        super(providerId);
        this.providerId = providerId;
        this.name = name;
        this.contact = contact;
    }

    public Provider(ProviderId providerId){
        super(providerId);
    }
    public void updateProviderName(Name name) {
        this.name= Objects.requireNonNull(name);
    }
    public void addContact(Contact contact) { this.contact = Objects.requireNonNull(contact);}

    public ProviderId getProviderId(){
        return providerId;
    }

    public Name getName(){
        return name;
    }

    public Contact getContact() { return contact;}

}
