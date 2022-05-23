package com.example.demo.selling;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.events.*;
import com.example.demo.selling.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SellingBook extends AggregateEvent<SellingBookId> {

    protected BookStore bookStore;
    protected Set<Seller> sellers;
    protected Set<Client> clients;
    protected Set<Selling> sellings;

    public SellingBook(SellingBookId sellingBookId, BookStore bookStore) {
        super(sellingBookId);
        appendChange(new SellingBookCreated(sellingBookId, bookStore)).apply();
    }

    private SellingBook(SellingBookId sellingBookIdId) {
        super(sellingBookIdId);
        subscribe(new SellingChange(this));
    }

    public static SellingBook from(SellingBookId sellingBookId, List<DomainEvent> events){
        var sellingBook = new SellingBook(sellingBookId);
        events.forEach(sellingBook::applyEvent);
        return sellingBook;
    }

    public void addSelling(SellingBookId sellingBookId, SellingId sellingId, Name name, Category category, Price price){
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(category);
        Objects.requireNonNull(price);
        appendChange(new SellingCreated(sellingBookId, sellingId, name, price, category)).apply();
    }

    public void addClient(SellingBookId sellingBookId, ClientId clientId, Name name){
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);
        appendChange(new ClientCreated(sellingBookId, clientId, name)).apply();
    }

    public void addSeller(SellingBookId sellingBookId, SellerId sellerId, Name name, SoldBooks soldBooks) {
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(sellerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(soldBooks);
        appendChange(new SellerCreated(sellingBookId, sellerId, name, soldBooks));
    }

    public void updateClientName(SellingBookId sellingBookId,ClientId clientId, Name name) {
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);
        appendChange(new ClientNameUpdated(sellingBookId,clientId, name)).apply();
    }

    public void updateSellerName(SellingBookId sellingBookId, SellerId sellerId, Name name) {
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(sellerId);
        Objects.requireNonNull(name);
        appendChange(new SellerNameUpdated(sellingBookId, sellerId, name)).apply();
    }

    public void updateBookName(SellingBookId sellingBookId, SellingId sellingId, Name name) {
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(name);
        appendChange(new BookNameUpdated(sellingBookId, sellingId, name)).apply();
    }

    public void addCategory(SellingBookId sellingBookId, SellingId sellingId, Category category) {
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(category);
        appendChange(new CategoryCreated(sellingBookId, sellingId, category)).apply();
    }

    public void addPrice(SellingBookId sellingBookId, SellingId sellingId, Price price) {
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(price);
        appendChange(new PriceCreated(sellingBookId,sellingId, price)).apply();
    }

    public void updateSoldBooks(SellingBookId sellingBookId, SellerId sellerId, SoldBooks soldBooks){
        Objects.requireNonNull(sellingBookId);
        Objects.requireNonNull(soldBooks);
        Objects.requireNonNull(sellerId);
        appendChange(new SoldBooksUpdated(sellingBookId,sellerId, soldBooks)).apply();
    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public Set<Selling> getSellings() {return sellings; }
}
