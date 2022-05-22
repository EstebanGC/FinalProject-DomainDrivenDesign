package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.BookId;
import com.example.demo.selling.values.Price;
import com.example.demo.selling.values.SellingId;

public class PriceCreated extends DomainEvent {

    private final SellingId sellingId;
    private final Price price;

    public PriceCreated(SellingId sellingId, Price price){
        super("sofka.price.pricecreated");
        this.sellingId = sellingId;
        this.price = price;
    }
    public SellingId getSellingId(){
        return sellingId;
    }
    public Price getPrice(){
        return price;
    }
}
