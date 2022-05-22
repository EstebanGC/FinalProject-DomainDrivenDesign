package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchasedBookId;



public class UpdateNumberOfBooks extends Command {
    private final PurchasedBookId purchasedBookId;
    private final NumberOfBooks numberOfBooks;

    public UpdateNumberOfBooks(PurchasedBookId purchasedBookId, NumberOfBooks numberOfBooks) {
        this.purchasedBookId = purchasedBookId;
        this.numberOfBooks = numberOfBooks;
    }

    public PurchasedBookId getpurchasedBookId(){
        return purchasedBookId;
    }

    public NumberOfBooks getNumberOfBooks() {
        return numberOfBooks;
    }
}

