package com.greensqa.model;

public class Company extends User {

    public Company() {
        super();
    }

    @Override
    public String getUserType() {
        return "COMPANY";
    }
}