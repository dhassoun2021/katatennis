package com.tennis.kata;

import com.tennis.kata.display.GameStandardOutpoutWriter;
import com.tennis.kata.display.GameTextFormater;
import com.tennis.kata.display.GameWriter;
import com.tennis.kata.validator.CommandValidator;

import java.util.Objects;

public class Game {
    private final Player playerA;
    private final Player playerB;
    private final ScoreEvaluator scoreEvaluator;
    private final GameWriter gameWriter;
    private final CommandValidator commandValidator;


    public Game () {
        this.gameWriter = new GameStandardOutpoutWriter();
        this.playerA = Player.of("A");
        this.playerB = Player.of("B");
        scoreEvaluator = new ScoreEvaluator();
        commandValidator = new CommandValidator();
    }
    public Game(GameWriter gameWriter) {
        this.gameWriter = gameWriter;
        this.playerA = Player.of("A");
        this.playerB = Player.of("B");
        scoreEvaluator = new ScoreEvaluator();
        commandValidator = new CommandValidator();
    }

    protected Game(Player playerA, Player playerB) {
        this.gameWriter = new GameStandardOutpoutWriter(new GameTextFormater());
        scoreEvaluator = new ScoreEvaluator();
        this.playerA = playerA;
        this.playerB = playerB;
        commandValidator = new CommandValidator();
    }

    public void play(String command) {
        commandValidator.validate(command);
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

    public Player getPlayer (String id) {
        if (Objects.equals(id, playerA.getId())) {
            return playerA;
        }
        if (Objects.equals(id, playerB.getId())) {
            return playerB;
        }
        throw new IllegalStateException("No players found with id "+ id);
    }

    public boolean isFinished () {
        return (playerA.hasWon() || playerB.hasWon());
    }

    protected void winPoint(String playerName) {
        Player playerScoreResult = scoreEvaluator.evaluate(playerName, this);
        updateScore(playerScoreResult.getId(), playerScoreResult.getScore());
        gameWriter.write(this);
    }

    private void updateScore (String playerName, Score score) {
        Player player = getPlayer(playerName);
        player.setScore(score);
    }
}

