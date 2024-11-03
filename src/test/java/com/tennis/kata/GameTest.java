package com.tennis.kata;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void play() {
        Game game = new Game();
        game.play("ABAA");
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        Assert.assertEquals(Score.FORTY, playerA.getScore());
        Assert.assertEquals(Score.FIFTEEN, playerB.getScore());
    }
}
