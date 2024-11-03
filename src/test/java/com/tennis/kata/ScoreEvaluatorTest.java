package com.tennis.kata;

import org.junit.Assert;
import org.junit.Test;

public class ScoreEvaluatorTest {

    @Test
    public void evaluate() {
        ScoreEvaluator scoreEvaluator = new ScoreEvaluator();
        Player winner = Player.of("A", Score.ZERO);
        Player other = Player.of("B", Score.ZERO);
        Player playerScoreResult = scoreEvaluator.evaluate("A", winner, other);
        Player playerResultExpected = Player.of("A", Score.FIFTEEN);
        Assert.assertEquals(playerResultExpected, playerScoreResult);
    }
}
