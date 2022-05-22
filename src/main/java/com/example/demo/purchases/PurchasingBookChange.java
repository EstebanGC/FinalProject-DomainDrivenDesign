package com.example.demo.purchases;

import co.com.sofka.domain.generic.EventChange;
import com.example.demo.purchases.commands.UpdatePurchasedBookName;
import com.example.demo.purchases.events.*;

import java.util.HashSet;

public class PurchasingBookChange extends EventChange {
    public PurchasingBookChange(PurchasingBook purchasingBook){
        apply((PurchasingBookCreated event)->{
           purchasingBook.bookStore = event.getBookStore();
           purchasingBook.purchasedBooks = new HashSet<>();
           purchasingBook.providers = new HashSet<>();
           purchasingBook.purchases = new HashSet<>();
        });

        apply((CategoryCreated event )-> {
            var purchased = new PurchasedBook(event.getPurchasedBookId());
            purchased.addCategory(event.getCategory());
        });

        apply((PriceCreated event )-> {
            var purchased = new PurchasedBook(event.getPurchasedBookId());
            purchased.addPrice(event.getPrice());
        });

        apply((PurchasedBookNameUpdated event )-> {
            var purchased = new PurchasedBook(event.getPurchasedBookId());
            purchased.updateBookName(event.getName());
        });

        apply((ProviderCreated event)-> {
            purchasingBook.providers.add(new Provider(event.getProviderId(), event.getName(), event.getContact()));
        });

        apply((ProviderNameUpdated event)-> {
           var provider = new  Provider(event.getProviderId());
           provider.updateProviderName(event.getName());
        });

        apply((ContactCreated event)->{
           var provider = new Provider(event.getProviderId());
           provider.addContact(event.getContact());
        });

        apply((PurchaseCreated event)-> {
           purchasingBook.purchases.add(new Purchase(event.getPurchaseId(), event.getNumberOfBooks(), event.getTotalPrice()));
        });

        apply((NumberOfBooksUpdated event)-> {
           var purchase = new Purchase(event.getPurchaseId()) ;
           purchase.updateNumberOfBooks(event.getNumberOfBooks());
        });

        apply((TotalPriceUpdated event)-> {
            var purchase = new Purchase(event.getPurchaseId());
            purchase.updateTotalPrice(event.getTotalPrice());
        });
    }
}
