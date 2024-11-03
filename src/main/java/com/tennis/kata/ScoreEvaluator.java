package com.tennis.kata;

import com.tennis.kata.util.PlayerUtil;

public class ScoreEvaluator {


    public Player evaluate(String winnerName, Game game) {
        Player winner = game.getPlayers().get(winnerName);
        Player other = game.getPlayers().get(PlayerUtil.opposite(winnerName));
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
            case ADVANTAGE:
                return Player.of(winnerName, Score.WIN);
        }
        throw new IllegalStateException("Enumeration " + winner.getScore() + "is not handled");
    }
}
