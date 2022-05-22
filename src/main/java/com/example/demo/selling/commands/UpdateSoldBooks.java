package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.SellingId;
import com.example.demo.selling.values.SoldBooks;

public class UpdateSoldBooks extends Command {
    private final SellingId sellingId;
    private final SoldBooks soldBooks;

    public UpdateSoldBooks(SellingId sellingId,SoldBooks soldBooks){
        this.sellingId = sellingId;
        this.soldBooks = soldBooks;
    }

    public SellingId getSellingBookId(){
        return sellingId;
    }
    public SoldBooks getSoldBooks(){
        return soldBooks;
    }
}
