package com.example.demo.purchases.values;

import co.com.sofka.domain.generic.ValueObject;
import com.example.demo.purchases.values.Contact;

import java.util.Objects;

public class Contact implements ValueObject<String> {
    private final String value;
    public Contact(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Contact is empty");
        }
    }

    @Override
    public String value() {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(value, contact.value);
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
