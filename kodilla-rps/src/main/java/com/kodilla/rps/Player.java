package com.kodilla.rps;

public class Player {
    private String name;
    private int score;
    private int choice;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
