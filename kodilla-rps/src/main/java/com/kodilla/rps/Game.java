package com.kodilla.rps;

import java.util.Random;
public class Game {
    private Player player;
    private Player computer;
    private int roundsToWin;

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
        return  random.nextInt(3) +  1;
    }

    private void calculateWinner(int playerChoice, int computerChoice) {
        if ((playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)) {
            player.increaseScore();
        } else if ((playerChoice == 1 && computerChoice == 2) ||
                (playerChoice == 2 && computerChoice == 3) ||
                (playerChoice == 3 && computerChoice == 1)) {
            computer.increaseScore();
        }
    }

    private  void showRoundResult(int playerChoice, int computerChoice) {

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
            return "It's a tie! (~_~) Try your luck nex time! :)";
        }
    }

}
