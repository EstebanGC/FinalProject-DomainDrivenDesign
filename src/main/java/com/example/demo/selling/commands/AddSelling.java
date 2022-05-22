package com.example.demo.selling.commands;

import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;

public class AddSelling {

    private final SellingBookId sellingBookId;
    private final SellingId sellingId;

    public AddSelling(SellingBookId sellingBookId, SellingId sellingId){

        this.sellingBookId = sellingBookId;
        this.sellingId= sellingId;
    }

    public SellingBookId getSellingBookId() {
        return sellingBookId;
    }

    public SellingId getSellingId(){
        return sellingId;
    }

}
