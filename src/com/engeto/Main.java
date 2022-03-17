package com.engeto;

public class Main {
    public static final String FILENAME = "vat–eu.csv";
    public static final String DELIMETR =  "/t";

    public static void main(String[] args) {
        Loading loading = new Loading();
        try {
            loading.loadFromFile(FILENAME, DELIMETR);

        } catch (Exception e){
            System.out.println("Špatný soubot k nahrání!");;
        }
        System.out.println("Název země (zkratka): základní sazba %" );

        for (State country : loading.getAllCountries()) {
            System.out.println(country.getDescription());
        }
    }
}
