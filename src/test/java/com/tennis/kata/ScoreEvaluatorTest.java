package com.tennis.kata;

import org.junit.Assert;
import org.junit.Test;

import static com.tennis.kata.Players.ID_PLAYER_A;
import static com.tennis.kata.Players.ID_PLAYER_B;

public class ScoreEvaluatorTest {

    @Test
    public void evaluate_Score_0_0_afterPlayerAWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerScoreResult = scoreEvaluator.evaluate(ID_PLAYER_A, Players.of(Score.ZERO, Score.ZERO));
        Player playerResultExpected = Player.of(ID_PLAYER_A, Score.FIFTEEN);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_15_30_afterPlayerBWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerScoreResult = scoreEvaluator.evaluate(ID_PLAYER_B, Players.of(Score.FIFTEEN, Score.THIRTY));
        Player playerResultExpected = Player.of(ID_PLAYER_B, Score.FORTY);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_40_40_afterPlayerAWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerScoreResult = scoreEvaluator.evaluate(ID_PLAYER_A, Players.of(Score.FORTY, Score.FORTY));
        Player playerResultExpected = Player.of(ID_PLAYER_A, Score.ADVANTAGE);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_40_A_afterPlayerAWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerScoreResult = scoreEvaluator.evaluate(ID_PLAYER_A, Players.of(Score.FORTY, Score.ADVANTAGE));
        Player playerResultExpected = Player.of(ID_PLAYER_B, Score.FORTY);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_40_A_afterPlayerBWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerScoreResult = scoreEvaluator.evaluate(ID_PLAYER_B, Players.of(Score.FORTY, Score.ADVANTAGE));
        Player playerResultExpected = Player.of(ID_PLAYER_B, Score.WIN);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }
}
