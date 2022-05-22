package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.ValueObject;
import com.example.demo.purchases.values.NumberOfBooks;

import java.util.Objects;

public class NumberOfBooks implements ValueObject<Integer> {

    private final Integer value;
    public NumberOfBooks(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<0){
            throw new IllegalArgumentException("The number of books can not be negative");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfBooks numberOfBooks = (NumberOfBooks) o;
        return Objects.equals(value, numberOfBooks.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
