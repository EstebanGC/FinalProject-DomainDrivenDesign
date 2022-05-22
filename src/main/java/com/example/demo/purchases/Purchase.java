package com.example.demo.purchases;

import co.com.sofka.domain.generic.Entity;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchaseId;
import com.example.demo.purchases.values.TotalPrice;

import java.util.Objects;

public class Purchase extends Entity<PurchaseId> {

    private PurchaseId purchaseId;
    private NumberOfBooks numberOfBooks;
    private TotalPrice totalPrice;

    public Purchase(PurchaseId purchaseId, NumberOfBooks numberOfBooks, TotalPrice totalPrice){
        super(purchaseId);
        this.numberOfBooks = numberOfBooks;
        this.totalPrice = totalPrice;
    }
    public Purchase(PurchaseId purchaseId){
        super(purchaseId);
    }



    public void updateTotalPrice(TotalPrice totalPrice){
        this.totalPrice = Objects.requireNonNull(totalPrice);
    }

    public void updateNumberOfBooks(NumberOfBooks numberOfBooks){
        this.numberOfBooks = Objects.requireNonNull(numberOfBooks);
    }
}

