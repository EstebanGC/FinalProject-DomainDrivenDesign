package com.example.demo.purchases;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.purchases.events.*;
import com.example.demo.purchases.values.*;
import com.example.demo.purchases.values.BookStore;

import java.awt.print.Book;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PurchasingBook extends AggregateEvent<PurchasingBookId> {

    protected BookStore bookStore;
    protected Set<PurchasedBook> purchasedBooks;
    protected Set<Provider> providers;
    protected Set<Purchase> purchases;

    public PurchasingBook(PurchasingBookId purchasingBookId,BookStore bookStore) {
        super(purchasingBookId);
        appendChange(new PurchasingBookCreated(purchasingBookId, bookStore)).apply();
    }

    private PurchasingBook(PurchasingBookId purchasingBookId){
        super(purchasingBookId);
        subscribe(new PurchasingBookChange(this));
    }

    public static PurchasingBook from(PurchasingBookId purchasingBookId, List<DomainEvent> events) {
        var purchasingBook = new PurchasingBook(purchasingBookId);
        events.forEach(purchasingBook::applyEvent);
        return purchasingBook;
    }

    public void addCategory(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Category category){
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(purchasedBookId);
        Objects.requireNonNull(category);
        appendChange(new CategoryCreated(purchasingBookId, purchasedBookId, category)).apply();
    }

    public void addPrice(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Price price){
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(purchasedBookId);
        Objects.requireNonNull(price);
        appendChange(new PriceCreated(purchasingBookId, purchasedBookId, price)).apply();
    }

    public void updatePurchasedBookName(PurchasingBookId purchasingBookId, PurchasedBookId purchasedBookId, Name name){
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(purchasedBookId);
        Objects.requireNonNull(name);
        appendChange(new PurchasedBookNameUpdated(purchasingBookId, purchasedBookId, name)).apply();
    }

    public void addProvider(PurchasingBookId purchasingBookId, ProviderId providerId, Name name, Contact contact){
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(providerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(contact);
        appendChange(new ProviderCreated(purchasingBookId, providerId, name, contact)).apply();
    }

    public void updateProviderName(PurchasingBookId purchasingBookId, ProviderId providerId, Name name){
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(providerId);
        Objects.requireNonNull(name);
        appendChange(new ProviderNameUpdated(purchasingBookId, providerId, name)).apply();
    }

    public void addContact(PurchasingBookId purchasingBookId, ProviderId providerId, Contact contact) {
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(providerId);
        Objects.requireNonNull(contact);
        appendChange(new ContactCreated(purchasingBookId, providerId, contact)).apply();
    }

    public void addPurchase(PurchasingBookId purchasingBookId, PurchaseId purchaseId, NumberOfBooks numberOfBooks, TotalPrice totalPrice){
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(purchaseId);
        Objects.requireNonNull(numberOfBooks);
        Objects.requireNonNull(totalPrice);
        appendChange(new PurchaseCreated(purchasingBookId, purchaseId, numberOfBooks, totalPrice)).apply();
    }

    public void updateNumberOfBooks(PurchasingBookId purchasingBookId, PurchaseId purchaseId, NumberOfBooks numberOfBooks) {
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(purchaseId);
        Objects.requireNonNull(numberOfBooks);
        appendChange(new NumberOfBooksUpdated(purchasingBookId, purchaseId, numberOfBooks)).apply();
    }

    public void updateTotalPrice(PurchasingBookId purchasingBookId, PurchaseId purchaseId, NumberOfBooks numberOfBooks, TotalPrice totalPrice) {
        Objects.requireNonNull(purchasingBookId);
        Objects.requireNonNull(purchaseId);
        Objects.requireNonNull(numberOfBooks);
        Objects.requireNonNull(totalPrice);
        appendChange(new TotalPriceUpdated(purchasingBookId, purchaseId, numberOfBooks, totalPrice)).apply();

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
