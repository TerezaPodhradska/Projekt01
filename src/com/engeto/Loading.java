package com.engeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loading {

    private List<Countries> countriesList;

    public void loadFile(String filename) throws ExceptionEu {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.addCountry(Countries.parse(line));
            }
        } catch (Exception e) {
            throw new ExceptionEu("Chyba při načtení");
        }
    }

    public void addCountry(Countries countries){
        countriesList.add(countries);
    }

    public List<Countries> getAllCountries() {
        return new ArrayList<>(countriesList);
    }
}
