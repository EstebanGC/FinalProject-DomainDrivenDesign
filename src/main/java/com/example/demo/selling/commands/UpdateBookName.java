package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingId;

public class UpdateBookName extends Command {
    private final SellingId sellingId;
    private final Name name;

    public UpdateBookName(SellingId sellingId,Name name){
        this.sellingId = sellingId;
        this.name = name;
    }

    public SellingId getSellingBookId(){
        return sellingId;
    }
    public Name getName(){
        return name;
    }
}
