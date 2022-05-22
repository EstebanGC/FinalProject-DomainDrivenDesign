package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingBookId;

public class AddClient extends Command {

    private final SellingBookId sellingBookId;
    private final ClientId clientId;
    private final Name name;


    public AddClient(SellingBookId sellingBookId, ClientId clientId, Name name) {
        this.sellingBookId = sellingBookId;
        this.clientId = clientId;
        this.name = name;
    }

    public SellingBookId getSellingBookId(){
        return sellingBookId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Name getName(){
        return name;
    }
}
