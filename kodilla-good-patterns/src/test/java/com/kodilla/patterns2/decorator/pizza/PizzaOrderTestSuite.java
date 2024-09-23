package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Ciasto ciękie, sos pomidorowy, ser", description);
    }

    @Test
    public void testPizzaWithHamCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);

        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(20), calculatedCost);
    }

    @Test
    public void testPizzaWithHamDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Ciasto ciękie, sos pomidorowy, ser, szynka", description);
    }

    @Test
    public void testPizzaWithHamAndMushroomsCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(24), calculatedCost);
    }

    @Test
    public void testPizzaWithHamAndMushroomsDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Ciasto ciękie, sos pomidorowy, ser, szynka, pieczarki", description);
    }

    @Test
    public void testPizzaWithAllIngredientsCost() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();

        // Then
        assertEquals(new BigDecimal(27), calculatedCost);
    }

    @Test
    public void testPizzaWithAllIngredientsDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("Ciasto ciękie, sos pomidorowy, ser, szynka, pieczarki, dodatkowy ser", description);
    }
}
