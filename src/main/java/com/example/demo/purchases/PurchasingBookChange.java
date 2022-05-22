package com.example.demo.purchases;

import co.com.sofka.domain.generic.EventChange;
import com.example.demo.purchases.events.PurchasingBookCreated;

public class PurchasingBookChange extends EventChange {
    public PurchasingBookChange(PurchasingBook purchasingBook){
        apply((PurchasingBookCreated event)->{
           purchasingBook.
        });
    }

}
