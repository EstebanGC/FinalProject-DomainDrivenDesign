package com.example.demo.selling.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Integer> {
    public final Integer value;
    public Price(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value<=0){
            throw new IllegalArgumentException("Price is empty");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
