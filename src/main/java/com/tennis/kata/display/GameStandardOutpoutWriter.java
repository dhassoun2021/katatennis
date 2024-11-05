package com.tennis.kata.display;

import com.tennis.kata.Game;

public class GameStandardOutpoutWriter implements GameWriter{

    private final GameFormater gameFormater;

    public GameStandardOutpoutWriter () {
        gameFormater = new GameTextFormater();
    }
    public GameStandardOutpoutWriter (GameFormater gameFormater) {
        this.gameFormater = gameFormater;
    }

    @Override
    public void write(Game game) {
       String content = gameFormater.format(game);
       System.out.println(content);
    }
}
