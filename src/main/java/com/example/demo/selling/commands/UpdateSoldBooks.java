package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;
import com.example.demo.selling.values.SoldBooks;

public class UpdateSoldBooks extends Command {
    private final SellingBookId sellingBookId;
    private final SellingId sellingId;
    private final SoldBooks soldBooks;

    public UpdateSoldBooks(SellingBookId sellingBookId, SellingId sellingId,SoldBooks soldBooks){
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.soldBooks = soldBooks;
    }

    public SellingBookId getSellingBookId() {
        return sellingBookId;
    }

    public SellingId getSellingId(){
        return sellingId;
    }
    public SoldBooks getSoldBooks(){
        return soldBooks;
    }
}
