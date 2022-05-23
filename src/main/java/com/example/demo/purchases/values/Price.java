package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Integer> {
    private final Integer value;
    public Price(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<0){
            throw new IllegalArgumentException("Price can not be negative");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.example.demo.selling.values.Price price = (com.example.demo.selling.values.Price) o;
        return Objects.equals(value, price.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }

}
