package com.engeto;

public class Main {
    public static final String FILENAME = "vat–eu.csv";

    public static void main(String[] args) throws ExceptionEu {
        Loading country = new Loading();
        try {
            country.loadFile(FILENAME);

         for (State country1 : country.getAllCountries()) {
         System.out.println(country1.getDescription());
         }

        } catch (Exception e){
            throw new ExceptionEu("špatný soubor");
        }
    }
}
