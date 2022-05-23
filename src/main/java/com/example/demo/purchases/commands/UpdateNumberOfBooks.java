package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;


public class UpdateNumberOfBooks extends Command {
    private final PurchasingBookId purchasingBookId;
    private final PurchasedBookId purchasedBookId;
    private final NumberOfBooks numberOfBooks;

    public UpdateNumberOfBooks(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, NumberOfBooks numberOfBooks) {
        this.purchasingBookId= purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.numberOfBooks = numberOfBooks;
    }

    public PurchasingBookId getPurchasingBookId() { return purchasingBookId;}

    public PurchasedBookId getpurchasedBookId(){
        return purchasedBookId;
    }

    public NumberOfBooks getNumberOfBooks() {
        return numberOfBooks;
    }
}

