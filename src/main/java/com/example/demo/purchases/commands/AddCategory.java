package com.example.demo.purchases.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.Category;

public class AddCategory extends Command {
    private final Category category;

    public AddCategory(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }


}
