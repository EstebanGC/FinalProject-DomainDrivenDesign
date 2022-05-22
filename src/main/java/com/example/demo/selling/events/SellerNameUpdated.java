package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellerId;
import com.example.demo.selling.values.SellingBookId;

public class SellerNameUpdated extends DomainEvent {
    private final SellingBookId sellingBookId;
    private final SellerId sellerId;
    private final Name name;

    public SellerNameUpdated(SellingBookId sellingBookId, SellerId sellerId, Name name) {
        super("sofka.name.nameupdated");
        this.sellingBookId = sellingBookId;
        this.sellerId = sellerId;
        this.name=name;
    }

    public SellingBookId getSellingBookId() { return sellingBookId; }

    public SellerId getSellerId() {
        return sellerId;
    }

    public Name getName(){
        return name;
    }
}
