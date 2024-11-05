package com.tennis.kata;

import com.tennis.kata.display.GameStandardOutpoutWriter;
import com.tennis.kata.display.GameTextFormater;
import com.tennis.kata.display.GameWriter;

import java.util.HashMap;
import java.util.Map;

public class Game {



    private final Map<String, Player> players = new HashMap<>();
    private final ScoreEvaluator scoreEvaluator;
    private final GameWriter gameWriter;


    public Game () {
        this.gameWriter = new GameStandardOutpoutWriter();
        Player playerA = Player.of("A");
        Player playerB = Player.of("B");
        players.put(playerA.getId(), playerA);
        players.put(playerB.getId(), playerB);
        scoreEvaluator = new ScoreEvaluator();
    }
    public Game(GameWriter gameWriter) {
        this.gameWriter = gameWriter;
        Player playerA = Player.of("A");
        Player playerB = Player.of("B");
        players.put(playerA.getId(), playerA);
        players.put(playerB.getId(), playerB);
        scoreEvaluator = new ScoreEvaluator();
    }

    protected Game(Player playerA ,Player playerB) {
        this.gameWriter = new GameStandardOutpoutWriter(new GameTextFormater());
        players.put(playerA.getId(), playerA);
        players.put(playerB.getId(), playerB);
        scoreEvaluator = new ScoreEvaluator();
    }

    public void play(String command) {
        //check command validity
       char [] chars = command.toCharArray();
       for (char c : chars) {
           if (isFinished()) {
               //TODO add warn log
               return;
           }
           String playerWin = String.valueOf(c);
           winPoint(playerWin);
       }
    }

    protected void winPoint(String playerName) {
        Player playerScoreResult = scoreEvaluator.evaluate(playerName, this);
        updateScore(playerScoreResult.getId(), playerScoreResult.getScore());
        gameWriter.write(this);
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

    public boolean isFinished () {
        return players.values().stream().anyMatch(Player::hasWon);
    }
}

