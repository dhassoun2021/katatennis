package com.tennis.kata;

import com.tennis.kata.util.PlayerUtil;

public class ScoreEvaluator {


    public Player evaluate(String winnerName, Game game) {
        Player winner = game.getPlayer(winnerName);
        Player opponent = game.getPlayer(PlayerUtil.opponent(winnerName));
        switch (winner.getScore()) {
            case ZERO:
                return Player.of(winnerName, Score.FIFTEEN);
            case FIFTEEN:
                return Player.of(winnerName, Score.THIRTY);
            case THIRTY:
                return Player.of(winnerName, Score.FORTY);
            case FORTY:
                if (opponent.getScore() == Score.FORTY) {
                    return Player.of(winnerName, Score.ADVANTAGE);
                }
                if (opponent.getScore() == Score.ADVANTAGE) {
                    return Player.of(opponent.getId(), Score.FORTY);
                }
            case ADVANTAGE:
                return Player.of(winnerName, Score.WIN);
        }
        throw new IllegalStateException("Enumeration " + winner.getScore() + "is not handled");
    }
}
