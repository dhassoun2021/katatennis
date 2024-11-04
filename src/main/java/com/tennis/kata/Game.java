package com.tennis.kata;

import java.util.HashMap;
import java.util.Map;

public class Game {



    private final Map<String, Player> players = new HashMap<>();
    private final ScoreEvaluator scoreEvaluator;

    public Game() {
        Player playerA = Player.of("A");
        Player playerB = Player.of("B");
        players.put(playerA.getName(), playerA);
        players.put(playerB.getName(), playerB);
        scoreEvaluator = new ScoreEvaluator();
    }
    protected Game(Player playerA ,Player playerB) {
        players.put(playerA.getName(), playerA);
        players.put(playerB.getName(), playerB);
        scoreEvaluator = new ScoreEvaluator();
    }

    public void play(String command) {
        //check command validity
       char [] chars = command.toCharArray();
       for (char c : chars) {
           if (hasFinished()) {
               //TODO add warn log
               return;
           }
           String playerWin = String.valueOf(c);
           onPlayerWin(playerWin);
       }
    }

    protected void onPlayerWin(String playerName) {
        Player playerScoreResult = scoreEvaluator.evaluate(playerName, this);
        updateScore(playerScoreResult.getName(), playerScoreResult.getScore());
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public Player getPlayer (String name) {
        return players.get(name);
    }

    public void updateScore (String playerName, Score score) {
        Player player = getPlayer(playerName);
        player.setScore(score);
    }

    public boolean hasFinished () {
        return players.values().stream().anyMatch(Player::hasWon);
    }
}

