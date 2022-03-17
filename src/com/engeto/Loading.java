package com.engeto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loading {



    private List<State> countriesList = new ArrayList<>();

    public void loadFromFile(String filename, String delimetr) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split(delimetr);
                String shortcut = items[0];
                String country = items[1];
                double fullTax = Double.parseDouble(items[2]);
                String item3 = items[3].replace(",", ".");
                double reducedTaxValue = Double.parseDouble(item3);
                boolean specialRate = Boolean.parseBoolean(items[4]);

                State state = new State(shortcut, country, fullTax, reducedTaxValue, specialRate);
                countriesList.add(state);
            }
        } catch (FileNotFoundException eu) {
            System.out.println("Chyba při načtení vstupního souboru");
        }  catch (NumberFormatException e) {
            System.err.println("Špatně zadané číslo" + e.getLocalizedMessage());
        }
    }

    public void saveToFile(String fileName, String delimetr) {
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
}
