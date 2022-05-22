package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.Category;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;

public class AddCategory extends Command {
    private final SellingBookId sellingBookId;
    private final SellingId sellingId;
    private final Category category;

    public AddCategory(SellingBookId sellingBookId, SellingId sellingId, Category category){
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.category = category;
    }

    public SellingBookId getSellingBookId(){ return sellingBookId;}

    public SellingId getSellingId(){ return sellingId; }

    public Category getCategory(){
        return category;
    }
}
