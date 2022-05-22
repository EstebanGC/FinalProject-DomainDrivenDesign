package com.example.demo.selling.commands;

import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;

public class AddPrice {
    private final SellingBookId sellingBookId;
    private final SellingId sellingId;
    private final Price price;

    public AddPrice(SellingBookId sellingBookId, SellingId sellingId, Price price){
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.price = price;
    }

    public SellingBookId getSellingBookId () { return sellingBookId; }
    public SellingId getSellingId(){
        return sellingId;
    }
    public Price getPrice(){
        return price;
    }
}
