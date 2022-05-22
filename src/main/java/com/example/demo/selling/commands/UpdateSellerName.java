package com.example.demo.selling.commands;

import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellerId;
import com.example.demo.selling.values.SellingBookId;

public class UpdateSellerName {
    private final SellingBookId  sellingBookId;
    private final SellerId sellerId;
    private final Name name;

    public UpdateSellerName(SellingBookId sellingBookId,  SellerId sellerId, Name name) {
        this.sellingBookId = sellingBookId;
        this.sellerId = sellerId;
        this.name=name;
    }

    public SellingBookId getSellingBookId() {
        return sellingBookId;
    }

    public SellerId getSellerId() {
        return sellerId;
    }

    public Name getName(){
        return name;
    }
}
