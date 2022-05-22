package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellerId;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SoldBooks;

public class SellerCreated extends DomainEvent {

    private final SellingBookId sellingBookId;
    private final SellerId sellerId;
    private final Name name;
    private final SoldBooks soldBooks;

    public SellerCreated(SellingBookId sellingBookId, SellerId sellerId, Name name, SoldBooks soldBooks) {
        super("sofka.seller.sellercreated");
        this.sellingBookId = sellingBookId;
        this.sellerId = sellerId;
        this.name = name;
        this.soldBooks = soldBooks;
    }

    public SellingBookId getSellingBookId() { return sellingBookId; }

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
