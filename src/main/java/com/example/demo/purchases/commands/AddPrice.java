package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.selling.values.Price;

public class AddPrice {
    private PurchasedBookId purchasedBookId;
    private final Price price;

    public AddPrice(Price price){
        this.price = price;
    }

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }
    public Price getPrice(){
        return price;
    }
}
