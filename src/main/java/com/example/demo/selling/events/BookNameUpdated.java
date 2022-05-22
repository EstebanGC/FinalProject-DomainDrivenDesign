package com.example.demo.selling.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.values.SellingBookId;
import com.example.demo.selling.values.SellingId;
import com.example.demo.selling.values.Name;
import com.example.demo.selling.values.SellingId;

public class BookNameUpdated extends DomainEvent {
    private SellingBookId sellingBookId;
    private SellingId sellingId;
    private final Name name;

    public BookNameUpdated(SellingBookId sellingBookId, SellingId sellingId, Name name){
        super("sofka.name.nameupdated");
        this.sellingBookId = sellingBookId;
        this.sellingId = sellingId;
        this.name=name;
    }

    public SellingBookId getSellingBookId() { return sellingBookId; }

    public SellingId getSellingId() { return sellingId;
    }
    public Name getName() {
        return name;
    }
}
