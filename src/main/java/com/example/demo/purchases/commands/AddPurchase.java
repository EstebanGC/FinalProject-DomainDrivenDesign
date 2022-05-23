package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchaseId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.purchases.values.TotalPrice;

public class AddPurchase extends Command {

    private final PurchasingBookId purchasingBookId;
    private final PurchaseId purchaseId;
    private final NumberOfBooks numberOfBooks;
    private final TotalPrice totalPrice;

    public AddPurchase(PurchasingBookId purchasingBookId, PurchaseId purchaseId, NumberOfBooks numberOfBooks, TotalPrice totalPrice) {

        this.purchasingBookId = purchasingBookId;
        this.purchaseId = purchaseId;
        this.numberOfBooks = numberOfBooks;
        this.totalPrice = totalPrice;
    }

     public PurchasingBookId getPurchasingBookId() { return purchasingBookId;}
     public PurchaseId getPurchaseId() {
        return purchaseId;
     }
     public NumberOfBooks getNumberOfBooks() { return numberOfBooks;}
     public TotalPrice getTotalPrice() { return totalPrice;}

}
