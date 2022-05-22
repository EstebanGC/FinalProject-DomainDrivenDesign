package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.Category;
import com.example.demo.selling.values.SellingId;

public class AddCategory extends Command {
    private final SellingId sellingId;
    private final Category category;

    public AddCategory(SellingId sellingId, Category category){
        this.sellingId = sellingId;
        this.category = category;
    }

    public SellingId getSellingId(){ return sellingId; }

    public Category getCategory(){
        return category;
    }
}
