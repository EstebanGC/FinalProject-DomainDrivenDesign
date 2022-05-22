package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.*;

public class SellingCreated extends DomainEvent {

    private final SellingId sellingId;
    private final Name name;
    private final Price price;
    private final Category category;

    public SellingCreated(SellingId sellingId, Name name, Price price, Category category){
        super("sofka.selling.sellingcreated");
        this.sellingId = sellingId;
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public SellingId getSellingBookId(){
        return sellingId;
    }

    public Name getName(){
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Category getCategory(){
        return category;
    }


}
