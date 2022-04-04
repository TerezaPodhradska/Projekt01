package com.engeto;

public class State02 {

    public String shortcut;
    public String country;
    public double fullTaxValue;
    public double reducedTaxValue;
    public boolean specialRate;


    public State02(String shortcut, String country, double fullTAxValue, double reducedTaxValue, boolean specialRate){
        this.shortcut = shortcut;
        this.country = country;
        this.fullTaxValue = fullTAxValue;
        this.reducedTaxValue = reducedTaxValue;
        this.specialRate = specialRate;
    }


    public String getDescription(){
        return country + " ("+shortcut+"): "+ fullTaxValue +"%";
    }

    public String getDescriptionOver20(){
        return country + " ("+shortcut+"): "+ fullTaxValue +"%" +" (" +reducedTaxValue + "%)";
    }
    public String getDescriptionUndere20(){
        return shortcut+", ";
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

    public void getSpecialRate(boolean specialRate) {
        this.specialRate = specialRate;
    }


}
