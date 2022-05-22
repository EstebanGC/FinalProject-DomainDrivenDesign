package com.example.demo.purchases.commands;

import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.selling.values.Name;

public class UpdatePurchasedBookName {

    private final PurchasingBookId purchasingBookId;
    private final Name name;


    public UpdatePurchasedBookName(PurchasingBookId purchasingBookId, Name name){
        this.purchasingBookId = purchasingBookId;
        this.name=name;
    }

    public PurchasingBookId getPurchasedBookId() { return purchasingBookId;
    }
    public Name getName() {
        return name;
    }


}
