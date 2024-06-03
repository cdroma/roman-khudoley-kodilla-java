package com.kodilla.rps;

public class RpsController {
    public static void welcomeToGame() {
        System.out.println("Welcome to game Rock, Paper, Scissors!");
    }

    public static void enteringName() {
        System.out.println("Please enter your name...");
    }

    public static void selectingRounds() {
        System.out.println("Now enter rounds to win your opponent....");
    }

    public static void makingChoise() {
        System.out.println("\nMake a choice...");
    }

    public static void choiseRock() {
        System.out.println("0. Rock");
    }

    public static void choisePaper() {
        System.out.println("1. Paper");
    }

    public static void choiseScissors() {
        System.out.println("2. Scissors");
    }

    public static void invalidChoiseMessage() {
        System.out.println("Please select numbers from 0 to 2 and try again!");
    }

    public static void gameOverMessage() {
        System.out.println("\nGame over!!!");
    }

    public static void computerWinsRoundMessage() {
        System.out.println("Computer wins this round!");
    }

    public static void tieMessage() {
        System.out.println("It's a tie!");
    }
}
