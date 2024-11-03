package com.tennis.kata;

import com.tennis.kata.display.GameStandardOutpoutWriter;
import com.tennis.kata.display.GameWriter;
import com.tennis.kata.validator.CommandValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This class is the entry point to play tennis's game between 2 players
 */
public class Game {

    private final Log log = LogFactory.getLog(Game.class);

    /**
     * Players playing the match
     */
    private final Players players;
    private final ScoreEvaluator scoreEvaluator;
    private final GameWriter gameWriter;
    private final CommandValidator commandValidator;


    public Game () {
        this.gameWriter = new GameStandardOutpoutWriter();
        this.players = Players.create();
        this.scoreEvaluator = new ScoreEvaluator();
        this.commandValidator = new CommandValidator();
    }
    public Game(GameWriter gameWriter) {
        this.gameWriter = gameWriter;
        this.players = Players.create();
        this.scoreEvaluator = new ScoreEvaluator();
        this.commandValidator = new CommandValidator();
    }

    /**
     * Play the match between 2 players from a command.
     * @param command Contains only character as A or B to tell respectively player A or player B wins the point. If the game is finished, and command is not ended, the rest of the command will be ignored.
     */
    public void play(String command) {
        commandValidator.validate(command);
        char [] chars = command.toCharArray();
        for (char c : chars) {
           if (isFinished()) {
               log.warn("Game is finished, the rest of the command will be ignored");
               return;
           }
           String playerWin = String.valueOf(c);
           winPoint(playerWin);
       }
    }

    public boolean isFinished () {
        return players.onePlayerHasWon();
    }

    public Players getPlayers() {
        return players;
    }

    private void winPoint(String playerId) {
        Player playerScoreResult = scoreEvaluator.evaluate(playerId, players);
        updateScore(playerScoreResult.getId(), playerScoreResult.getScore());
        gameWriter.write(players);
    }

    private void updateScore (String playerId, Score score) {
        Player player = players.getPlayer(playerId);
        player.setScore(score);
    }
}

