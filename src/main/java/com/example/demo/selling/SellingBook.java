package com.example.demo.selling;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.example.demo.selling.events.*;
import com.example.demo.selling.values.*;

import java.awt.print.Book;
import java.util.HashSet;
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
        return null; //complete
    }

    public void addSelling(SellingId sellingId, Name name, Category category, Price price){
        Objects.requireNonNull(name);
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(category);
        Objects.requireNonNull(price);
        appendChange(new SellingCreated(sellingId, name, price, category)).apply();
    }

    public void addClient(ClientId clientId, Name name){
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);
        appendChange(new ClientCreated(clientId, name)).apply();
    }

    public void addSeller(SellerId sellerId, Name name, SoldBooks soldBooks) {
        Objects.requireNonNull(sellerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(soldBooks);
        appendChange(new SellerCreated(sellerId, name, soldBooks));
    }

    public void updateClientName(ClientId clientId, Name name) {
        Objects.requireNonNull(name);
        appendChange(new ClientNameUpdated(clientId, name)).apply();
    }

    public void updateSellerName(SellerId sellerId, Name name) {
        Objects.requireNonNull(sellerId);
        Objects.requireNonNull(name);
        appendChange(new SellerNameUpdated(sellerId, name)).apply();
    }

    public void updateBookName(SellingId sellingId, Name name) {
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(name);
        appendChange(new BookNameUpdated(sellingId, name)).apply();
    }

    public void addCategory(SellingId sellingId, Category category) {
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(category);
        appendChange(new CategoryCreated(sellingId, category)).apply();
    }

    public void addPrice(SellingId sellingId, Price price) {
        Objects.requireNonNull(sellingId);
        Objects.requireNonNull(price);
        appendChange(new PriceCreated(sellingId, price)).apply();
    }

    public void updateSoldBooks(SellerId sellerId, SoldBooks soldBooks){
        Objects.requireNonNull(soldBooks);
        Objects.requireNonNull(sellerId);
        appendChange(new SoldBooksUpdated(sellerId, soldBooks)).apply();
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
