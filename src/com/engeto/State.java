package com.engeto;

public class State {

    public String shortcut;
    public String country;
    public double fullTaxValue;
    public double reducedTaxValue;
    public boolean specialRate;


    public State(String shortcut, String country, double fullTAxValue, double reducedTaxValue, boolean specialRate){
        this.shortcut = shortcut;
        this.country = country;
        this.fullTaxValue = fullTAxValue;
        this.reducedTaxValue = reducedTaxValue;
        this.specialRate = specialRate;
    }


    public String getDescription(){
        return country + " ("+shortcut+"): "+ fullTaxValue +"%";
    }

    public static State parse(String text) throws ExceptionEu {
        try {

            String[] items = text.split("/t");
            String shortcut = items[0];
            String country = items[1];
            double fullTax = Double.parseDouble(items[2]);
            String item3 = items[3];
            if (item3.contains(",")) {
                item3.replace(",", ".");
            }
            double reducedTaxValue = Double.parseDouble(item3);
            boolean specialRate = Boolean.parseBoolean(items[4]);

            return new State(shortcut, country, fullTax, reducedTaxValue, specialRate);
        } catch (NumberFormatException ex){
            throw new ExceptionEu("Nelze správně rozložit soubor");
        }
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

    public double getFullTAxValue() {
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
