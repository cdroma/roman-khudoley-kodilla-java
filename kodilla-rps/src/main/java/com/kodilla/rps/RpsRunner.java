package com.kodilla.rps;

import java.util.Scanner;
public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to  game Rock, Paper, Scissors!");

        System.out.println("Please enter your name...");
        String playerName = scanner.nextLine();

        System.out.println("Now enter rounds to win your opponent....");
        int roundsToWin = scanner.nextInt();

        Player computer = new Player("Evil computer");
        Player player = new Player(playerName);

        Game game = new Game(player, computer, roundsToWin);

        while (!game.gameOver()) {
            System.out.println("\nMake a choice...");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");

            int playerChoice = scanner.nextInt();
            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Please select numbers from 1 to 3 and try again!");
                continue;
            }

            game.playRound(playerChoice);
        }

        System.out.println("\nGame over!!!");
        System.out.println("The winner is:" + " " + game.getWinner());
    }
}
