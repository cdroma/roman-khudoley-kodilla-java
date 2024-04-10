package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        Calculator calculator1 = new Calculator();

        int result1 = calculator1.substractAFromB(15, 8);

        if (result1==7) {
            System.out.println("Test OK, \n15-8=" + result1);
        } else {
            System.out.println("Error!");
        }

        Calculator calculator2 = new Calculator();

        int result2 = calculator2.sumAandB(7, 3);

        if (result2==10) {
            System.out.println("Test OK, \n7+3=" + result2);
        } else {
            System.out.println("Error!");
        }

        System.out.println("End of test...");
    }
}
