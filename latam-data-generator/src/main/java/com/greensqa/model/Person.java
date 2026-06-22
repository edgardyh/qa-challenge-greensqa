package com.greensqa.model;

public class Person extends User {

    public Person() {
        super();
    }

    @Override
    public String getUserType() {
        return "PERSON";
    }
}