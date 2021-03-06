package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BookStore implements ValueObject<Integer> {

    private final Integer value;

    public BookStore(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<0) {
            throw new IllegalArgumentException("The book store can not be negative");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStore bookStore = (BookStore) o;
        return Objects.equals(value, bookStore.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
