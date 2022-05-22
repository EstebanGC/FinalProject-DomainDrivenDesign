package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;
import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingId;

public class PriceCreated extends DomainEvent {

    private final SellingBookId sellingBookId;
    private final SellingId sellingId;
    private final Price price;

    public PriceCreated(SellingBookId sellingBookId, SellingId sellingId, Price price){
        super("sofka.price.pricecreated");
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.price = price;
    }

    public SellingBookId getSellingBookId() { return sellingBookId;}
    public SellingId getSellingId(){
        return sellingId;
    }
    public Price getPrice(){
        return price;
    }
}
