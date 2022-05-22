package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;

public class ClientCreated extends DomainEvent {

    private final ClientId clientId;
    private final Name name;


    public ClientCreated(ClientId clientId, Name name) {
        super("sofka.client.clientcreated");
        this.clientId = clientId;
        this.name = name;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Name getName(){
        return name;
    }
}
