package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.SellingId;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingId;

public class BookNameUpdated extends DomainEvent {
    private SellingId sellingId;
    private final Name name;

    public BookNameUpdated(SellingId sellingId, Name name){
        super("sofka.name.nameupdated");
        this.sellingId = sellingId;
        this.name=name;
    }

    public Name getName() {
        return name;
    }

    public SellingId getSellingId() { return sellingId;
    }
}
