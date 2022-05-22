package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.selling.values.Name;

public class AddContact {
    private final ProviderId providerId;
    private final Contact contact;


    public AddContact(ProviderId providerId, Contact contact) {
        this.providerId = providerId;
        this.contact = contact;
    }

    public ProviderId getProviderId() {
        return providerId;
    }

    public Contact getContact(){
        return contact;
    }
}
