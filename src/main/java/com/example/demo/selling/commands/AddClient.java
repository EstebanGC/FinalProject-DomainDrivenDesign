package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;

public class AddClient extends Command {
    private final ClientId clientId;
    private final Name name;


    public AddClient(ClientId clientId, Name name) {
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
