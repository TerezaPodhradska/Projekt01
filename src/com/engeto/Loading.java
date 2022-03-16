package com.engeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loading {

    private List<State> countriesList;

    public void loadFile(String filename) throws ExceptionEu {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){
            int linew = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                linew++;
                try {
                    this.addCountry(State.parse(line));
                } catch (ExceptionEu e){
                    throw new ExceptionEu("Nečitelný řádek");
                }
            }
        } catch (ExceptionEu | FileNotFoundException e) {
            throw new ExceptionEu("Chyba při načtení vstupního souboru");
        }
    }

    public void addCountry(State countries){
        countriesList.add(countries);
    }

    public List<State> getAllCountries() {
        return new ArrayList<>(countriesList);
    }
}
