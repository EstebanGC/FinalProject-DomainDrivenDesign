package com.example.demo.selling.values;

import co.com.sofka.domain.generic.Identity;

public class SellingBookId extends Identity {
    public SellingBookId(){
    }
    private SellingBookId(String uid){
        super(uid);
    }
    public static SellingBookId of(String uid){
        return new SellingBookId(uid);
    }
}
