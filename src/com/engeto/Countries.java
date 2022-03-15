package com.engeto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Countries {

    public String shortcut;
    public String country;
    public int fullTaxValue;
    public double reducedTaxValue;
    public boolean specialRate;


    public Countries(String shortcut, String country, int fullTAxValue, double reducedTaxValue, boolean specialRate){
        this.shortcut = shortcut;
        this.country = country;
        this.fullTaxValue = fullTAxValue;
        this.reducedTaxValue = reducedTaxValue;
        this.specialRate = specialRate;
    }


    public String getDescription(){
        return country + " ("+shortcut+"): "+ fullTaxValue +"%";
    }

    public static Countries parse(String text) {
        String[] items = text.split("/t");
        String shorcut = items[0];
        String country = items[1];
        int fullTax = Integer.parseInt(items[2]);
        String item3 = items[3];
        if (item3.contains(",")) {
            item3.replace(",", ".");
        }
        double reducedTaxValue = Double.parseDouble(item3);
        boolean specialRate = Boolean.parseBoolean(items[4]);

        return new Countries(shorcut, country, fullTax, reducedTaxValue, specialRate);
    }






    //GETTER AND SETTER
    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFullTAxValue() {
        return fullTaxValue;
    }

    public void setFullTAxValue(int fullTAxValue) {
        this.fullTaxValue = fullTAxValue;
    }

    public double getReducedTaxValue() {
        return reducedTaxValue;
    }

    public void setReducedTaxValue(double reducedTaxValue) {
        this.reducedTaxValue = reducedTaxValue;
    }

    public boolean isSpecialRate() {
        return specialRate;
    }

    public void setSpecialRate(boolean specialRate) {
        this.specialRate = specialRate;
    }


}
