package com.tennis.kata;

import com.tennis.kata.display.GameTextDisplayer;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void scenarioWithPlayerA_40AndPlayerB_30() {
        Game game = new Game(new GameTextDisplayer());
        game.play("ABAA");
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.FIFTEEN, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_WonAndPlayerB_30() {
        Game game = new Game(new GameTextDisplayer());
        game.play("ABABAA");
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.WIN, playerA.getScore());
        Assert.assertEquals(Score.THIRTY, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_WonAndPlayerB_30ShouldReturnSameScoreWhenAnotherCommand() {
        Game game = new Game(new GameTextDisplayer());
        game.play("ABABAAB");
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.WIN, playerA.getScore());
        Assert.assertEquals(Score.THIRTY, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_40AndPlayerB_40() {
        Game game = new Game(new GameTextDisplayer());
        game.play("ABABABAB");
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.FORTY, playerB.getScore());
    }
    @Test
    public void scenarioWithPlayerA_40AndPlayerB_A() {
        Game game = new Game(new GameTextDisplayer());
        game.play("ABABABABB");
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.ADVANTAGE, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_0AndPlayerB_0() {
        Game game = new Game(new GameTextDisplayer());
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.ZERO, playerA.getScore());
        Assert.assertEquals(Score.ZERO, playerB.getScore());
    }
}
