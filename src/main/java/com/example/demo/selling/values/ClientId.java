package com.example.demo.selling.values;

import co.com.sofka.domain.generic.Identity;

public class ClientId extends Identity {

    public ClientId(){
    }
    private ClientId(String uid){
        super(uid);
    }
    public static ClientId of(String uid){
        return new ClientId(uid);
    }
}
