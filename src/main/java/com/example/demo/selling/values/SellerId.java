package com.example.demo.selling.values;

import co.com.sofka.domain.generic.Identity;

public class SellerId extends Identity {
    public SellerId(){
    }
    private SellerId(String uid){
        super(uid);
    }
    public static SellerId of(String uid){
        return new SellerId(uid);
    }
}
