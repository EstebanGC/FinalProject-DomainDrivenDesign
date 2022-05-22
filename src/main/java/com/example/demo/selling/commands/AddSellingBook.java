package com.example.demo.selling.commands;

import com.example.demo.selling.values.BookStore;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;

public class AddSellingBook {
    private final SellingBookId sellingBookId;

    public AddSellingBook(SellingBookId sellingBookId){
        this.sellingBookId= sellingBookId;
    }

    public SellingBookId getSellingBookIdId(){
        return sellingBookId;
    }
}
