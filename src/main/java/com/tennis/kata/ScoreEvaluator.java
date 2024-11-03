package com.tennis.kata;

/**
 * This class has responsibility to evaluate score between 2 players
 */
public class ScoreEvaluator {

    /**
     * Evaluate score for winner's id
     * @param winnerId Id of winner (player which won the point)
     * @param players Players of the game
     * @return The player which score has changed
     */
    public Player evaluate(String winnerId, Players players) {
        Player winner = players.getPlayer(winnerId);
        Player opponent = players.getOpponent(winnerId);
        switch (winner.getScore()) {
            case ZERO:
                return Player.of(winnerId, Score.FIFTEEN);
            case FIFTEEN:
                return Player.of(winnerId, Score.THIRTY);
            case THIRTY:
                return Player.of(winnerId, Score.FORTY);
            case FORTY:
                if (opponent.getScore() == Score.FORTY) {
                    return Player.of(winnerId, Score.ADVANTAGE);
                }
                if (opponent.getScore() == Score.ADVANTAGE) {
                    return Player.of(opponent.getId(), Score.FORTY);
                }
            case ADVANTAGE:
                return Player.of(winnerId, Score.WIN);
        }
        throw new IllegalStateException("Enumeration " + winner.getScore() + "is not handled");
    }
}
