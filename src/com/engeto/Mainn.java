package com.engeto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mainn {
    public static final String FILENAME = "vat–eu.csv";
    public static final String DELIMITER =  "\t";

    public static void main(String[] args) throws IOException {

        // projde soubor a vytiskne všechny státy
        Loading02 loading = new Loading02();
        try {
            loading.loadFromFile(FILENAME, DELIMITER);
        } catch (Exception e){
            System.out.println("Špatný soubot k nahrání!"+ e.getLocalizedMessage());
        }
        System.out.println("Název země (zkratka): základní sazba %" );
        for (State02 country : loading.getAllCountries()) {
            System.out.println(country.getDescription());
        }

        // projde soubor a vytiskne státy s vat 20+
        System.out.println("================================================");
        System.out.println("Sazba VAT 20+% a nepoužívají specialní sazbu");
        loading.compareTo();
        List<String> statesOver20 = new ArrayList<>();
        for (State02 country : loading.getAllCountries()) {
            if ((country.getFullTAxValue() > 20)&& (!country.isSpecialRate())) {
                System.out.println(country.getDescriptionOver20());
                statesOver20.add(country.getDescriptionOver20());
            }
        }
        // projde soubor a vytiskne státy s vat nižší než 20
        statesOver20.add("==================================");
        statesOver20.add("Sazba VAT nižší než 20% nebo používají speciální sazbu: ");
        System.out.println("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
        for (State02 country : loading.getAllCountries()) {
            if ((country.getFullTAxValue() <= 20) && country.isSpecialRate()) {
                System.out.print(country.getDescriptionUndere20());
                statesOver20.add(country.getDescriptionUndere20());
            }
        }

        //nahraje výpis do souboru
        FileWriter writer = new FileWriter("vat-over-20.txt");
        for(String state: statesOver20) {
            writer.write(state + System.lineSeparator());
        }
        writer.close();



        // hodnoty s určenou hranicí minimalního VAT
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte minimalní hodnotu VAT: ");
        String minVatValueString = scanner.nextLine();
        int minVatValue;
        if(minVatValueString.equals("")){
            minVatValue = 20;
        } else {
            minVatValue = Integer.parseInt(minVatValueString);
        }
        System.out.println("Sazba VAT " + minVatValue + "+% : ");
        loading.compareTo();
        List<String> statesOverX = new ArrayList<String>();
        for (State02 country : loading.getAllCountries()) {
            if ((country.getFullTAxValue() > minVatValue)) {
                System.out.println(country.getDescriptionOver20());
                statesOverX.add(country.getDescriptionOver20());
            }
        }
        //nahraje výpis do nového souboru
        String fileXName = "vat-over-"+minVatValueString+".txt";
        try (FileWriter writerX = new FileWriter(fileXName)) {
            for (String state : statesOverX) {
                writerX.write(state + System.lineSeparator());
            }
            writerX.close();
            System.out.println("Jméno souboru, ve kterém se státy nacházejí: " + fileXName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
