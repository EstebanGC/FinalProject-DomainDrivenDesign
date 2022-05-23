package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.purchases.values.Name;

public class AddProvider extends Command {
    private final PurchasingBookId purchasingBookId;
    private final ProviderId providerId;
    private final Name name;
    private final Contact contact;


    public AddProvider(PurchasingBookId purchasingBookId, ProviderId providerId, Name name, Contact contact) {
        this.purchasingBookId = purchasingBookId;
        this.providerId = providerId;
        this.name = name;
        this.contact = contact;
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

    public Contact getContact() { return contact;}
}
