package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;

public class UpdateBookName extends Command {

    private final SellingBookId sellingBookId;
    private final SellingId sellingId;
    private final Name name;

    public UpdateBookName(SellingBookId sellingBookId, SellingId sellingId,Name name){
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.name = name;
    }

    public SellingBookId getSellingBookId() {return sellingBookId;}
    public SellingId getSellingId(){
        return sellingId;
    }
    public Name getName(){
        return name;
    }
}
