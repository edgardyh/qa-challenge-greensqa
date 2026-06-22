package com.greensqa.model;

public abstract class User {

    protected String name;
    protected String lastName;
    protected int age;
    protected String document;
    protected String city;
    protected String country;
    protected String language;
    protected String origen;    // Nuevo
    protected String destino;

    public User() {
    }

    public User(String name,
                String lastName,
                int age,
                String document,
                String city,
                String country,
                String language,
                String origen,
                String destino) {

        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.document = document;
        this.city = city;
        this.country = country;
        this.language = language;
        this.origen = origen;
        this.destino = destino;
    }

    public abstract String getUserType();

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getDocument() {
        return document;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

}