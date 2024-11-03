package com.tennis.kata.display;

import com.tennis.kata.Players;

/**
 * This class has responsibility to display players data to standard output
 */
public class GameStandardOutpoutWriter implements GameWriter{

    private final GameFormater gameFormater;

    public GameStandardOutpoutWriter () {
        gameFormater = new GameTextFormater();
    }
    public GameStandardOutpoutWriter (GameFormater gameFormater) {
        this.gameFormater = gameFormater;
    }

    @Override
    public void write(Players players) {
       String content = gameFormater.format(players);
       System.out.println(content);
    }
}
