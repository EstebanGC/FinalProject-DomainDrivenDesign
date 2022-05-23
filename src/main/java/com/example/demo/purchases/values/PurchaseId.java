package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.Identity;

public class PurchaseId extends Identity {
    public PurchaseId(){
    }
    private PurchaseId(String uid){
        super(uid);
    }
    public static PurchaseId of(String uid){
        return new PurchaseId(uid);
    }
}
