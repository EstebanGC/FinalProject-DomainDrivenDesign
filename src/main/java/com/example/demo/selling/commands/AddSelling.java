package com.example.demo.selling.commands;

import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingId;

public class AddSelling {
    private final SellingId sellingId;

    public AddSelling(SellingId sellingId){
        this.sellingId= sellingId;
    }

    public SellingId getSellingId(){
        return sellingId;
    }

}
