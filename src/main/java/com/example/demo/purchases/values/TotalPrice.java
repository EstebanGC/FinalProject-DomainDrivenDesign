package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TotalPrice implements ValueObject<Integer> {

    private final Integer value;
    public TotalPrice(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<0){
            throw new IllegalArgumentException("The total price can not be negative");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalPrice totalPrice = (TotalPrice) o;
        return Objects.equals(value, totalPrice.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
