package com.tennis.kata.display;

import com.tennis.kata.Players;
import com.tennis.kata.Score;
import org.junit.Assert;
import org.junit.Test;

public class GameTextFormaterTest {

    @Test
    public void gameFormatWithPlayerA_30AndPlayerB_15 () {
        GameTextFormater gameTextFormater = new GameTextFormater();
        String resultExpected = "Player A: 30 / Player B: 15";
        String result = gameTextFormater.format(Players.of(Score.THIRTY, Score.FIFTEEN));
        Assert.assertEquals(resultExpected, result);
    }

    @Test
    public void gameFormatWithPlayerAWinsTheGame () {
        GameTextFormater gameTextFormater = new GameTextFormater();
        String resultExpected = "Player A wins the game";
        String result = gameTextFormater.format(Players.of(Score.WIN, Score.FIFTEEN));
        Assert.assertEquals(resultExpected, result);
    }

    @Test
    public void gameFormatWithPlayerBWinsTheGame () {
        GameTextFormater gameTextFormater = new GameTextFormater();
        String resultExpected = "Player B wins the game";
        String result = gameTextFormater.format(Players.of(Score.FIFTEEN, Score.WIN));
        Assert.assertEquals(resultExpected, result);
    }
}
