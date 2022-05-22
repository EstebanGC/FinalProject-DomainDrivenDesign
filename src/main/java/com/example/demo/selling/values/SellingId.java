package com.example.demo.selling.values;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;

public class SellingId extends Identity {
    public SellingId(){
    }
    private SellingId(String uid){
        super(uid);
    }
    public static SellingId of(String uid){
        return new SellingId(uid);
    }
}
