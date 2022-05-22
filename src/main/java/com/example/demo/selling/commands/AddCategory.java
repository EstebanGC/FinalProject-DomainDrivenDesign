package com.example.demo.selling.commands;

import com.example.demo.selling.values.Category;

public class AddCategory {
    private final Category category;

    public AddCategory(Category category){
        this.category = category;
    }

    public Category getCategory(){
        return category;
    }
}
