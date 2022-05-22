package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;

public class ClientNameUpdated extends DomainEvent {
    private final Name name;
    private final ClientId clientId;

    public ClientNameUpdated(ClientId clientId, Name name){
        super("sofka.name.nameupdated");
        this.clientId = clientId;
        this.name=name;
    }

    public Name getName() {
        return name;
    }

    public ClientId getClientId() { return clientId;
    }
}
