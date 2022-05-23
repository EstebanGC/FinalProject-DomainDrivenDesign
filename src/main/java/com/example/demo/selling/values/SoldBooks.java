package com.example.demo.selling.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SoldBooks implements ValueObject<Integer> {
    private final Integer value;

    public SoldBooks(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<0) {
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
        SoldBooks soldBooks = (SoldBooks) o;
        return Objects.equals(value, soldBooks.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }


}
