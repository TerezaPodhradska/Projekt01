package com.engeto;

public class Main {
    public static final String FILENAME = "vat–eu.csv";
    public static void main(String[] args) throws ExceptionEu {
        Loading countries = new Loading();
        countries.loadFile(FILENAME);
        for (Countries country : countries.getAllCountries()) {
            System.out.println(country.getDescription());
        }
    }
}
