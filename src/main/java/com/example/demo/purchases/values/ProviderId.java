package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.Identity;

public class ProviderId extends Identity {
    public ProviderId(){
    }
    private ProviderId(String uid){
        super(uid);
    }
    public static ProviderId of(String uid){
        return new ProviderId(uid);
    }
}
