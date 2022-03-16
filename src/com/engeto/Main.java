package com.engeto;

public class Main {
    public static final String FILENAME = "vat–eu.csv";

    public static void main(String[] args) {
        Loading country = new Loading();
        try {
            country.loadFile(FILENAME);

         for (State country1 : country.getAllCountries()) {
         System.out.println(country1.getDescription());
         }

        } catch (ExceptionEu e){
            e.printStackTrace();
        }
    }
}
