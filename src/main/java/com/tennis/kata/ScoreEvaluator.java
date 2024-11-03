package com.tennis.kata;

public class ScoreEvaluator {


    public Player evaluate(String winnerName, Player winner, Player other) {
        switch (winner.getScore()) {
            case ZERO:
                return Player.of(winnerName, Score.FIFTEEN);
            case FIFTEEN:
                return Player.of(winnerName, Score.THIRTY);
            case THIRTY:
                return Player.of(winnerName, Score.FORTY);
            case FORTY:
                if (other.getScore() == Score.FORTY) {
                    return Player.of(winnerName, Score.ADVANTAGE);
                }
                if (other.getScore() == Score.ADVANTAGE) {
                    return Player.of(other.getName(), Score.FORTY);
                }
                return Player.of(winnerName, Score.WIN);
        }
        throw new IllegalStateException("Enumeration " + winner.getScore() + "is not handled");
    }
}
