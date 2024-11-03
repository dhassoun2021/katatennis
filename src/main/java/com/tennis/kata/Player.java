package com.tennis.kata;

import com.tennis.kata.validator.PlayerIdValidator;

import java.util.Objects;

public class Player {
    private final String id;
    private Score score;

    private Player(String id) {
        PlayerIdValidator.validatePlayerId(id);
        this.id = id;
        this.score = Score.ZERO;
    }

    private Player (String id, Score score) {
        PlayerIdValidator.validatePlayerId(id);
        this.id = id;
        this.score = score;
    }

    public static Player of(String id) {
        return new Player(id);
    }

    public static Player of(String id, Score score) {
        return new Player(id, score);
    }

    public String getId() {
        return id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public boolean hasWon() {
        return score == Score.WIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }
}
