package com.example.bddcodelab.domain;

import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
