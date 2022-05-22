package com.example.demo.selling.commands;

import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingId;

public class AddPrice {
    private SellingId sellingId;
    private final Price price;

    public AddPrice(SellingId sellingId,Price price){
        this.price = price;
    }

    public SellingId getSellingBookId(){
        return sellingId;
    }
    public Price getPrice(){
        return price;
    }
}
