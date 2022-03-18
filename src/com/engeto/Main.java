package com.engeto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILENAME = "vat–eu.csv";
    public static final String DELIMITER =  "\t";

    public static void main(String[] args) throws IOException {

        // projde soubor a vytiskne všechny státy
        Loading loading = new Loading();
        try {
            loading.loadFromFile(FILENAME, DELIMITER);

        } catch (Exception e){
            System.out.println("Špatný soubot k nahrání!"+ e.getLocalizedMessage());
        }
        System.out.println("Název země (zkratka): základní sazba %" );

        for (State country : loading.getAllCountries()) {
            System.out.println(country.getDescription());
        }

        // projde soubor a vytiskne státy s vat 20+
        System.out.println("================================================");
        System.out.println("Sazba VAT 20+% a nepoužívají specialní sazbu");
        loading.compareTo();
        List<String> statesOver20 = new ArrayList<String>();
        for (State country : loading.getAllCountries()) {

            if ((country.getFullTAxValue() > 20)&& (country.isSpecialRate() == false)) {
                System.out.println(country.getDescriptionOver20());
                statesOver20.add(country.getDescriptionOver20());
            }
        }
        // projde soubor a vytiskne státy s vat nižší než 20
        statesOver20.add("==================================");
        statesOver20.add("Sazba VAT nižší než 20% nebo používají speciální sazbu: ");
        System.out.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
        for (State country : loading.getAllCountries()) {
            if ((country.getFullTAxValue() <= 20) && ( country.isSpecialRate()== true)) {
                System.out.println(country.getDescriptionUndere20());
                statesOver20.add(country.getDescriptionUndere20());
            }
        }

        //nahraje výpis do souboru
        FileWriter writer = new FileWriter("vat-over-20.txt");
        for(String str: statesOver20) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();

    }
}
