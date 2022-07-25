package util;

import entity.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryUtil {

    public List<Country> getAll() {
        List<Country> countries =
                new ArrayList<>();
        countries.add(new Country("BD", "Bangladesh"));
        countries.add(new Country("USA", "United States of America"));
        countries.add(new Country("CAD", "Canada"));
        return countries;
    }
}
