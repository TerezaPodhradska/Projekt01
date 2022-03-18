package com.engeto;

import java.io.*;
import java.util.*;

public class Loading {


    private List<State> countriesList = new ArrayList<>();
    private ArrayList<State> countriesListOver20 = new ArrayList<>();


    public void loadFromFile(String filename, String delimiter) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(delimiter);
                String shortcut = items[0];
                String country = items[1];
                double fullTax = Double.parseDouble(items[2]);
                String item3 = items[3].replace(",", ".");
                double reducedTaxValue = Double.parseDouble(item3);
                boolean specialRate = Boolean.parseBoolean(items[4]);

                State state = new State(shortcut, country, fullTax, reducedTaxValue, specialRate);
                countriesList.add(state);
                countriesListOver20.add(state);
            }
        } catch (FileNotFoundException eu) {
            System.out.println("Chyba při načtení vstupního souboru");
        } catch (NumberFormatException e) {
            System.err.println("Špatně zadané číslo" + e.getLocalizedMessage());
        }
    }

    public void loadFromFileOver20(String filename, String delimiter) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split("delimiter");
                double fullTax = Double.parseDouble(items[2]);
                boolean specialRate = Boolean.parseBoolean(items[4]);
                if ((fullTax >= 20) && (specialRate == false)) {
                    String shortcut = items[0];
                    String country = items[1];
                    String item3 = items[3].replace(",", ".");
                    double reducedTaxValue = Double.parseDouble(item3);
                    State state = new State(shortcut, country, fullTax, reducedTaxValue, specialRate);
                    countriesListOver20.add(state);
                } else {
                    System.out.println("=======================================");
                    String shortcut = items[0];
                    String country = items[1];
                    String item3 = items[3].replace(",", ".");
                    double reducedTaxValue = Double.parseDouble(item3);

                    State state = new State(shortcut, country, fullTax, reducedTaxValue, specialRate);
                    countriesList.add(state);
                    countriesListOver20.add(state);
                }
            }
        } catch (FileNotFoundException eu) {
            System.out.println("Chyba při načtení vstupního souboru");
        } catch (NumberFormatException e) {
            System.err.println("Špatně zadané číslo" + e.getLocalizedMessage());
        }
    }

    public void saveToFile(String fileName) {
        String delimetr = "\t";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (State s : countriesList) {
                String outputLine = s.getShortcut() + delimetr;
                outputLine += s.getCountry() + delimetr;
                outputLine += s.getFullTAxValue() + delimetr;
                outputLine += s.getReducedTaxValue() + delimetr;
                outputLine += s.isSpecialRate() + "\n";
                writer.print(outputLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<State> getAllCountries() {
        return new ArrayList<>(countriesList);
    }


    public void compareTo() {
        Collections.sort(getAllCountries(), new Compare());
    }

}