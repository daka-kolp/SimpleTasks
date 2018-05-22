package com.darya;

public class Address {
    private String firstName;
    private String lastName;
    private String street;
    private int home;
    private int appartment;
    private String city;
    private String state;
    private long zipCode;

    public Address(String firstName, String lastName, String street, int home, int appartment, String city, String state, long zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.home = home;
        this.appartment = appartment;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getAppartment() {
        return appartment;
    }

    public String getCity() {
        return city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setAppartment(int appartment) {
        this.appartment = appartment;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public long getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return "Name: " + firstName +
                "\nSurname: " + lastName +
                "\nState: " + state +
                "\nCity: " + city +
                "\nStreet: " + street +
                " " + home + "/" + appartment +
                "\nZIP code: " + zipCode;
    }
}
