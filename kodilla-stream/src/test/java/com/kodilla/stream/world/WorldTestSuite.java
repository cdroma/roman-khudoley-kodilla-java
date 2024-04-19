package com.kodilla.stream.world;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class WorldTestSuite {
    @Test
    @DisplayName("People quantity test")
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent africa = new Continent("Africa");

        europe.addCountry(new Country("Poland", new BigDecimal("36820000")));
        europe.addCountry(new Country("Estonia", new BigDecimal("1349000")));

        africa.addCountry(new Country("Zimbabwe", new BigDecimal("16320000")));
        africa.addCountry(new Country("Ghana", new BigDecimal("33480000")));

        world.addContinent(europe);
        world.addContinent(africa);

        //When
        BigDecimal allPopulation = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("87969000"), allPopulation);
    }
}
