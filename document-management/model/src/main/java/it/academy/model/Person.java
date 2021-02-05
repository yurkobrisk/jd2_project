package it.academy.model;

public class Person {

    private int id;

    private String name;

    private String surname;

    private String passportNumber;

    private Address address;

    private class Address {

        private String country;

        private String city;

        private String street;

        private int idex;
    }
}
