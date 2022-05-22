package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.Category;

public class AddCategory extends Command {
    private final PurchasedBookId purchasedBookId;
    private final Category category;

    public AddCategory(PurchasedBookId purchasedBookId, Category category){
        this.purchasedBookId = purchasedBookId;
        this.category = category;
    }

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }

    public Category getCategory(){
        return category;
    }


}
