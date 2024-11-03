package com.tennis.kata;

import java.util.HashMap;
import java.util.Map;

public class Game {



    private final Map<String, Player> players = new HashMap<>();
    private final ScoreEvaluator scoreEvaluator;

    public Game(Player playerA ,Player playerB) {
        players.put(playerA.getName(), playerA);
        players.put(playerB.getName(), playerB);
        scoreEvaluator = new ScoreEvaluator();
    }

    public void onPlayerWin(String playerName) {
        Player winner = players.get(playerName);
        String oppositePlayerName = PlayerUtil.opposite(playerName);
        Player other = players.get(oppositePlayerName);
        Player playerScoreResult = scoreEvaluator.evaluate(playerName, winner, other);
        players.put(playerScoreResult.getName(), playerScoreResult);
    }
}

