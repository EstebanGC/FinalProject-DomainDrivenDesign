package com.example.demo.selling.commands;

import com.example.demo.selling.values.ClientId;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingBookId;

public class UpdateClientName {

    private final SellingBookId sellingBookId;
    private final ClientId clientId;
    private final Name name;

    public UpdateClientName(SellingBookId sellingBookId, ClientId clientId,Name name){
        this.sellingBookId = sellingBookId;
        this.clientId = clientId;
        this.name=name;
    }

    public SellingBookId getSellingBookId() {
        return sellingBookId;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Name getName() {
        return name;
    }
}
