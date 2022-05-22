package com.example.demo.selling.commands;

import com.example.demo.selling.values.Name;

public class UpdateClientName {
    private final Name name;

    public UpdateClientName(Name name){
        this.name=name;
    }

    public Name getName() {
        return name;
    }
}
