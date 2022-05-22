package com.example.demo.selling;

import co.com.sofka.domain.generic.Entity;
import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;

import java.util.Objects;

public class Client extends Entity<ClientId> {
    private ClientId clientId;
    private Name name;


    public Client(ClientId clientId, Name name) {
        super(clientId);
        this.clientId = clientId;
        this.name = name;
    }

    public Client(ClientId clientId){
        super(clientId);
    }

    public void updateClientName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public ClientId getClientId(){ return clientId; }

    public Name getName() {
        return name;
    }


}
