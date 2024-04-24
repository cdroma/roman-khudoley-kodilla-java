package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(5, 0);
            System.out.println("Division result:" + " " + result);
        } catch (ArithmeticException exception) {
            System.out.println("Exception:" + " " + exception.getMessage() + " " + "\nDivision on 0 is not correct in Math!");
        } finally {
            System.out.println("End of operations");
        }
    }
}
