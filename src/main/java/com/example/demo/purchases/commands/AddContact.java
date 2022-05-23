package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.Contact;
import com.example.demo.purchases.values.ProviderId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.selling.values.Name;

public class AddContact {
    private final PurchasingBookId purchasingBookId;
    private final ProviderId providerId;
    private final Contact contact;


    public AddContact(PurchasingBookId purchasingBookId,ProviderId providerId, Contact contact) {
        this.purchasingBookId = purchasingBookId;
        this.providerId = providerId;
        this.contact = contact;
    }

    public PurchasingBookId getPurchasingBookId() { return purchasingBookId;}
    
    public ProviderId getProviderId() {
        return providerId;
    }

    public Contact getContact(){
        return contact;
    }
}
