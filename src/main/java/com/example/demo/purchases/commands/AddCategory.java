package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.purchases.values.PurchasedBookId;
import com.example.demo.purchases.values.Category;
import com.example.demo.purchases.values.PurchasingBookId;

public class AddCategory extends Command {
    private final PurchasingBookId purchasingBookId;
    private final PurchasedBookId purchasedBookId;
    private final Category category;

    public AddCategory(PurchasingBookId purchasingBookId,PurchasedBookId purchasedBookId, Category category){
        this.purchasingBookId = purchasingBookId;
        this.purchasedBookId = purchasedBookId;
        this.category = category;
    }

    public PurchasingBookId getPurchasingBookId(){
        return purchasingBookId;
    }

    public PurchasedBookId getPurchasedBookId(){
        return purchasedBookId;
    }

    public Category getCategory(){
        return category;
    }


}
