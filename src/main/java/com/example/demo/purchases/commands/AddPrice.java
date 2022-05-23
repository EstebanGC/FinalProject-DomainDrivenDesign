package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.selling.values.Price;

public class AddPrice {
    private final PurchasingBookId purchasingBookId;
    private final PurchasedBookId purchasedBookId;
    private final Price price;

    public AddPrice(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Price price){
        this.purchasingBookId = purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.price = price;
    }

    public PurchasingBookId getPurchasingBookId() {return purchasingBookId;}
    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }
    public Price getPrice(){
        return price;
    }
}
