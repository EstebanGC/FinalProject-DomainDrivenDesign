package com.example.demo.purchases;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.events.*;
import com.example.demo.purchases.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PurchasingBook extends AggregateEvent<PurchasingBookId> {

    protected BookStore bookStore;
    protected Set<PurchasedBook> purchasedBooks;
    protected Set<Provider> providers;
    protected Set<Purchase> purchases;

    public PurchasingBook(PurchasingBookId purchasingBookId, BookStore bookStore) {

        super(purchasingBookId);
        appendChange(new PurchasingBookCreated(purchasingBookId, bookStore)).apply();
    }

    private PurchasingBook(PurchasingBookId purchasingBookId){
        super(purchasingBookId);
        subscribe(new PurchasingBookChange(this));
    }

    public static PurchasingBook from(PurchasingBook purchasingBook, List<DomainEvent> events) {
        return null;//complete
    }

    public addCategory(PurchasedBookId purchasedBookId, Category category){
        Objects.requireNonNull(purchasedBookId);
        Objects.requireNonNull(category);
        appendChange(new CategoryCreated(purchasedBookId, category)).apply();
    }

    public addPrice(PurchasedBookId purchasedBookId, Price price){
        Objects.requireNonNull(purchasedBookId);
        Objects.requireNonNull(price);
        appendChange(new PriceCreated(purchasedBookId, price)).apply();
    }

    public updatePurchasedBookName(PurchasedBookId purchasedBookId, Name name){
        Objects.requireNonNull(purchasedBookId);
        Objects.requireNonNull(name);
        appendChange(new PurchasedBookNameUpdated(purchasedBookId, name)).apply();
    }

    public updateProviderName(ProviderId providerId, Name name){
        Objects.requireNonNull(providerId);
        Objects.requireNonNull(name);
        appendChange(new ProviderNameUpdated(providerId, name)).apply();
    }

    public addContact(ProviderId providerId, Contact contact) {
        Objects.requireNonNull(providerId);
        Objects.requireNonNull(contact);
        appendChange(new ContactCreated(providerId, contact)).apply();
    }

    public updateNumberOfBooks(PurchaseId purchaseId, NumberOfBooks numberOfBooks) {
        Objects.requireNonNull(purchaseId);
        Objects.requireNonNull(numberOfBooks);
        appendChange(new NumberOfBooksUpdated(purchaseId, numberOfBooks)).apply();
    }

    public updateTotalPrice(PurchaseId purchaseId, NumberOfBooks numberOfBooks, TotalPrice totalPrice) {
        Objects.requireNonNull(purchaseId);
        Objects.requireNonNull(numberOfBooks);
        Objects.requireNonNull(totalPrice);
        appendChange(new TotalPriceUpdated(purchaseId, numberOfBooks, totalPrice)).apply();

    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public Set<PurchasedBook> getPurchasedBooks() {
        return purchasedBooks;
    }

    public Set<Provider> getProviders() {
        return providers;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }
}
