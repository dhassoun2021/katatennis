package com.tennis.kata;

import org.junit.Assert;
import org.junit.Test;

public class ScoreEvaluatorTest {

    @Test
    public void evaluate_Score_0_0_afterPlayerAWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerA = Player.of("A", Score.ZERO);
        Player playerB = Player.of("B", Score.ZERO);
        Game game = new Game(playerA, playerB);
        Player playerScoreResult = scoreEvaluator.evaluate("A", game);
        Player playerResultExpected = Player.of("A", Score.FIFTEEN);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_15_30_afterPlayerBWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerA = Player.of("A", Score.FIFTEEN);
        Player playerB = Player.of("B", Score.THIRTY);
        Game game = new Game(playerA, playerB);
        Player playerScoreResult = scoreEvaluator.evaluate("B", game);
        Player playerResultExpected = Player.of("B", Score.FORTY);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_40_40_afterPlayerAWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerA = Player.of("A", Score.FORTY);
        Player playerB = Player.of("B", Score.FORTY);
        Game game = new Game(playerA, playerB);
        Player playerScoreResult = scoreEvaluator.evaluate("A", game);
        Player playerResultExpected = Player.of("A", Score.ADVANTAGE);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_40_A_afterPlayerAWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerA = Player.of("A", Score.FORTY);
        Player playerB = Player.of("B", Score.ADVANTAGE);
        Game game = new Game(playerA, playerB);
        Player playerScoreResult = scoreEvaluator.evaluate("A", game);
        Player playerResultExpected = Player.of("B", Score.FORTY);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }

    @Test
    public void evaluate_Score_40_A_afterPlayerBWin() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player playerA = Player.of("A", Score.FORTY);
        Player playerB = Player.of("B", Score.ADVANTAGE);
        Game game = new Game(playerA, playerB);
        Player playerScoreResult = scoreEvaluator.evaluate("B", game);
        Player playerResultExpected = Player.of("B", Score.WIN);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }
}
