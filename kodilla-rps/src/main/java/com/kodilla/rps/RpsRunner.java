package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RpsController.welcomeToGame();

        RpsController.enteringName();
        String playerName = scanner.nextLine();

        RpsController.selectingRounds();
        int roundsToWin = scanner.nextInt();

        Player computer = new Player("Evil computer");
        Player player = new Player(playerName);

        Game game = new Game(player, computer, roundsToWin);

        while (!game.gameOver()) {
            RpsController.makingChoise();
            RpsController.choiseRock();
            RpsController.choisePaper();
            RpsController.choiseScissors();

            int playerChoice = scanner.nextInt();
            if (playerChoice < 0 || playerChoice > 2) {
                RpsController.invalidChoiseMessage();
                continue;
            }

            game.playRound(playerChoice);
        }

        RpsController.gameOverMessage();
        System.out.println("The winner is: " + game.getWinner());
    }
}
