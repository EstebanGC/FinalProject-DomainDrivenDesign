package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.NumberOfBooks;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.PurchasingBookId;
import com.example.demo.purchases.values.TotalPrice;

public class UpdateTotalPrice extends Command {
    private final PurchasingBookId purchasingBookId;
    private final PurchasedBookId purchasedBookId;
    private final TotalPrice totalPrice;

    public UpdateTotalPrice(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, TotalPrice totalPrice) {
        this.purchasingBookId = purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.totalPrice = totalPrice;
    }

    public PurchasingBookId getPurchasingBookId() { return purchasingBookId; }

    public PurchasedBookId getpurchasedBookId(){
        return purchasedBookId;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }
}
