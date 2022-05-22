package com.example.demo.purchases.values;


import co.com.sofka.domain.generic.Identity;


public class PurchasedBookId extends Identity {
    public PurchasedBookId(){
        super();
    }
    private PurchasedBookId(String uid){
        super(uid);
    }
    public static PurchasedBookId of(String uid){
        return new PurchasedBookId(uid);
    }

}
