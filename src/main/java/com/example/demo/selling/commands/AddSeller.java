package com.example.demo.selling.commands;

import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellerId;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SoldBooks;

public class AddSeller {

    private final SellingBookId sellingBookId;
    private final SellerId sellerId;
    private final Name name;
    private final SoldBooks soldBooks;

    public AddSeller(SellingBookId sellingBookId, SellerId sellerId, Name name, SoldBooks soldBooks) {
        this.sellingBookId = sellingBookId;
        this.sellerId = sellerId;
        this.name = name;
        this.soldBooks = soldBooks;
    }

    public SellingBookId getSellingBookId(){ return sellingBookId; }

    public SellerId getSellerId() {
        return sellerId;
    }

    public Name getName(){
        return name;
    }

    public SoldBooks getSoldBooks() {
        return soldBooks;
    }
}
