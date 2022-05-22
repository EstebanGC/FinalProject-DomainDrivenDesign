package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.selling.values.SellingBookId;

public class AddPurchasingBook {
    private final PurchasingBookId purchasingBookId;

    public AddPurchasingBook(PurchasingBookId  purchasingBookId){
        this.purchasingBookId= purchasingBookId;
    }

    public PurchasingBookId getPurchasingBookId(){
        return purchasingBookId;
    }
}
