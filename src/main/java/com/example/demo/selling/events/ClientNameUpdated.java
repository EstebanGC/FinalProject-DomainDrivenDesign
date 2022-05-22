package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingBookId;

public class ClientNameUpdated extends DomainEvent {

    private final SellingBookId sellingBookId;
    private final ClientId clientId;
    private final Name name;

    public ClientNameUpdated(SellingBookId sellingBookId, ClientId clientId, Name name){
        super("sofka.name.nameupdated");
        this.sellingBookId = sellingBookId;
        this.clientId = clientId;
        this.name=name;
    }

    public SellingBookId getSellingBookId() { return sellingBookId; }

    public ClientId getClientId() { return clientId;}

    public Name getName() {
        return name;
    }
}
