package com.kodilla.stream.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    @DisplayName("Average test")
    void testGetAverage() {
        //Given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //When
        double average = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(5.0, average);
    }
}
