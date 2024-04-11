package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test OddNumbersExterminator class")
class CollectionTestSuite {

    @BeforeEach
    void beforeEach() {
        System.out.println("The test is starting...");
    }

    @AfterEach
    void afterEach() {
        System.out.println("End of test!");
    }

    @Test
    @DisplayName("Test OddNumbersExterminator with empty list")
    void testOddNumbersExterminatorEmptyList() {
        // Given
        List<Integer> emptyList = new ArrayList<>();

        // When
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        assertEquals(0, result.size(), "List is empty");
    }

    @Test
    @DisplayName("Test OddNumbersExterminator with normal list")
    void testOddNumbersExterminatorNormalList() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        // When
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> result = exterminator.exterminate(numbers);

        // Then
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10, 12);
        assertEquals(expected, result, "List should have only even numbers");
    }
}
