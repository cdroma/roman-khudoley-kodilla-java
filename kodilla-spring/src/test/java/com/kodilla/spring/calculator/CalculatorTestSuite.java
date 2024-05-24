package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    @DisplayName("Easy calculations test")
    void testCalculations() {

        double addResult = calculator.add(4, 3);
        Assertions.assertEquals(7, addResult);

        double subResult = calculator.sub(5, 4);
        Assertions.assertEquals(1, subResult);

        double mulResult = calculator.mul(7, 7);
        Assertions.assertEquals(49, mulResult);

        double divResult = calculator.div(25, 5);
        Assertions.assertEquals(5, divResult);
    }
}
