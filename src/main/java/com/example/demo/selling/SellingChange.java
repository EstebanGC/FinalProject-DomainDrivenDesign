package com.example.demo.selling;

import co.com.sofka.domain.generic.EventChange;
import com.example.demo.selling.events.*;
import com.example.demo.selling.values.BookStore;
import com.example.demo.selling.values.SoldBooks;

import java.util.HashSet;

public class SellingChange extends EventChange {
    public SellingChange( SellingBook sellingBook){
        apply((SellingBookCreated event) -> {
            sellingBook.bookStore = event.getBookStore();
            sellingBook.sellers = new HashSet<>();
            sellingBook.clients = new HashSet<>();
            sellingBook.sellings = new HashSet<>();
        });

        apply((SellerNameUpdated event)-> {
            var seller = new Seller(event.getSellerId());
            seller.updateSellerName(event.getName());
        });

        apply((SellerCreated event)-> {
            sellingBook.sellers.add(new Seller(event.getSellerId(), event.getName(), event.getSoldBooks()));
        });

        apply((SoldBooksUpdated event)-> {
            var seller = new Seller(event.getSellerId());
            seller.updateSoldBooks(event.getSoldBooks());
        });

        apply((ClientNameUpdated event)-> {
            var client = new Client(event.getClientId());
            client.updateClientName(event.getName());
        });

        apply((ClientCreated event)-> {
            sellingBook.clients.add(new Client(event.getClientId(), event.getName()));
        });

        apply((SellingCreated event)-> {
            sellingBook.sellings.add(new Selling(event.getSellingBookId(), event.getCategory(), event.getName(), event.getPrice()));
        });

        apply((BookNameUpdated event)-> {
            var selling = new Selling(event.getSellingId());
            selling.updateName(event.getName());
        });

        apply((CategoryCreated event)->{
            var selling = new Selling(event.getSellingId());
            selling.addCategory(event.getCategory());
        });

        apply((PriceCreated event)-> {
            var selling = new Selling(event.getSellingId());
            selling.addPrice(event.getPrice());
        });
    }
}
