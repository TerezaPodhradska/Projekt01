package com.engeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loading {

    private List<State> countriesList;

    public void loadFile(String filename) throws ExceptionEu {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    this.addCountry(State.parse(line));
                } catch (Exception e){
                    throw new ExceptionEu("Nečitelný řádek");
                }
            }
        } catch (Exception e) {
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
