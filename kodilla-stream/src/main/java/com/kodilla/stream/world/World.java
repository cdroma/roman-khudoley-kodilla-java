package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class World {
    private List<Continent> continents;
    public World() {
        this.continents = new ArrayList<>();
    }
    public void addContinent(Continent continent) {
        continents.add(continent);
    }
    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
