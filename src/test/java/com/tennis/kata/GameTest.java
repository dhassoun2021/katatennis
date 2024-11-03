package com.tennis.kata;

import com.tennis.kata.exceptions.InvalidCommandException;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test(expected = InvalidCommandException.class)
    public void scenarioWithCommandNull() {
        Game game = new Game();
        game.play(null);
    }

    @Test(expected = InvalidCommandException.class)
    public void scenarioWithCommandEmpty() {
        Game game = new Game();
        game.play("");
    }

    @Test(expected = InvalidCommandException.class)
    public void scenarioWithCommandBlank() {
        Game game = new Game();
        game.play(" ");
    }

    @Test(expected = InvalidCommandException.class)
    public void scenarioWithInvalidCommand() {
        Game game = new Game();
        game.play("ABCAB");
    }

    @Test
    public void scenarioWithPlayerA_40AndPlayerB_30() {
        Game game = new Game();
        game.play("ABAA");
        Player playerA = game.getPlayers().getPlayer("A");
        Player playerB = game.getPlayers().getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.FIFTEEN, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_WonAndPlayerB_30() {
        Game game = new Game();
        game.play("ABABAA");
        Player playerA = game.getPlayers().getPlayer("A");
        Player playerB = game.getPlayers().getPlayer("B");
        Assert.assertEquals(Score.WIN, playerA.getScore());
        Assert.assertEquals(Score.THIRTY, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_WonAndPlayerB_30ShouldReturnSameScoreAndIgnoreTheRestOfTheCommand() {
        Game game = new Game();
        game.play("ABABAAB");
        Player playerA = game.getPlayers().getPlayer("A");
        Player playerB = game.getPlayers().getPlayer("B");
        Assert.assertEquals(Score.WIN, playerA.getScore());
        Assert.assertEquals(Score.THIRTY, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_40AndPlayerB_40() {
        Game game = new Game();
        game.play("ABABABAB");
        Player playerA = game.getPlayers().getPlayer("A");
        Player playerB = game.getPlayers().getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.FORTY, playerB.getScore());
    }
    @Test
    public void scenarioWithPlayerA_40AndPlayerB_A() {
        Game game = new Game();
        game.play("ABABABABB");
        Player playerA = game.getPlayers().getPlayer("A");
        Player playerB = game.getPlayers().getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.ADVANTAGE, playerB.getScore());
    }

    @Test
    public void scenarioWithPlayerA_0AndPlayerB_0() {
        Game game = new Game();
        Player playerA = game.getPlayers().getPlayer("A");
        Player playerB = game.getPlayers().getPlayer("B");
        Assert.assertEquals(Score.ZERO, playerA.getScore());
        Assert.assertEquals(Score.ZERO, playerB.getScore());
    }
}
