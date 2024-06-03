package com.kodilla.rps;

import java.util.Random;

public class Game {
    private Player player;
    private Player computer;
    private int roundsToWin;

    private final int[][] calculateWinner = {
            {0, -1, 1},  // Rock (0)
            {1, 0, -1},  // Paper (1)
            {-1, 1, 0}   // Scissors (2)
    };

    public Game(Player player, Player computer, int roundsToWin) {
        this.player = player;
        this.computer = computer;
        this.roundsToWin = roundsToWin;
    }

    public void playRound(int playerChoice) {
        player.setChoice(playerChoice);
        int computerChoice = generateComputerChoice();
        calculateWinner(playerChoice, computerChoice);
        showRoundResult(playerChoice, computerChoice);
    }

    private int generateComputerChoice() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private void calculateWinner(int playerChoice, int computerChoice) {
        int result = calculateWinner[playerChoice][computerChoice];
        if (result == 1) {
            player.increaseScore();
        } else if (result == -1) {
            computer.increaseScore();
        }
    }

    private void showRoundResult(int playerChoice, int computerChoice) {
        System.out.println(player.getName() + " chose: " + convertChoiceToString(playerChoice));
        System.out.println("Computer chose: " + convertChoiceToString(computerChoice));

        int result = calculateWinner[playerChoice][computerChoice];
        if (result == 1) {
            System.out.println(player.getName() + " wins this round!");
        } else if (result == -1) {
            RpsController.computerWinsRoundMessage();
        } else {
            RpsController.tieMessage();
        }
    }

    private String convertChoiceToString(int choice) {
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "None of above";
        }
    }

    public boolean gameOver() {
        return player.getScore() >= roundsToWin || computer.getScore() >= roundsToWin;
    }

    public String getWinner() {
        if (player.getScore() > computer.getScore()) {
            return player.getName();
        } else if (player.getScore() < computer.getScore()) {
            return computer.getName();
        } else {
            return "It's a tie! (~_~) Try your luck next time! :)";
        }
    }
}
