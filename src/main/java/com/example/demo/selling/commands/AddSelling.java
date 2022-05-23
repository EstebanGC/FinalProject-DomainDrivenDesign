package com.example.demo.selling.commands;

import co.com.sofka.domain.generic.Command;
import com.example.demo.selling.values.*;

public class AddSelling extends Command {


    private final SellingBookId sellingBookId;
    private final SellingId sellingId;
    private final Name name;
    private final Category category;
    private final Price price;

    public AddSelling(SellingBookId sellingBookId, SellingId sellingId, Name name, Category category, Price price){

        this.sellingBookId = sellingBookId;
        this.sellingId= sellingId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public SellingBookId getSellingBookId() {
        return sellingBookId;
    }

    public SellingId getSellingId(){
        return sellingId;
    }

    public Name getName() { return name;}

    public Category getCategory() { return category;}

    public Price getPrice() {
        return price;
    }
}
