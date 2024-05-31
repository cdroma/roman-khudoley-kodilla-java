package com.kodilla.good.patterns.builder.bigmac;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    @DisplayName("Testing Bigmac Builder")
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .burgers(2)
                .sauce("big mac")
                .ingredient("salad")
                .ingredient("onion")
                .ingredient("bacon")
                .build();

        // When
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        // Then
        assertEquals("with sesame", bun);
        assertEquals(2, burgers);
        assertEquals("big mac", sauce);
        assertTrue(ingredients.contains("salad"));
        assertTrue(ingredients.contains("onion"));
        assertTrue(ingredients.contains("bacon"));
        assertEquals(3, ingredients.size());
    }
}
