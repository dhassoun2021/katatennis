package com.tennis.kata;

import java.util.Objects;

public class Player {
    private final String name;
    private Score score;

    private Player(String name) {
        this.name = name;
        this.score = Score.ZERO;
    }

    private Player (String name, Score score) {
        this.name = name;
        this.score = score;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public static Player of(String name, Score score) {
        return new Player(name, score);
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
