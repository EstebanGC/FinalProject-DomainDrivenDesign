package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.selling.values.Price;

public class AddPrice {
    private PurchasedBookId purchasedBookId;
    private final Price price;

    public AddPrice(PurchasedBookId purchasedBookId, Price price){
        this.purchasedBookId = purchasedBookId;
        this.price = price;
    }

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }
    public Price getPrice(){
        return price;
    }
}
