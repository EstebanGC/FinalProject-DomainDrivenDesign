package com.example.demo.selling.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BookStore implements ValueObject<Integer> {

    public final Integer value;

    public BookStore(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<0) {
            throw new IllegalArgumentException("The book store has to have a number of books");
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
