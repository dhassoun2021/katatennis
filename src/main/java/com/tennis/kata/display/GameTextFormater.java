package com.tennis.kata.display;

import com.tennis.kata.Game;
import com.tennis.kata.Player;

public class GameTextFormater implements GameFormater {
    @Override
    public String format(Game game) {
        Player playerA = game.getPlayer("A");
        Player playerB = game.getPlayer("B");
        if (playerA.hasWon()) {
            return "Player A wins the game";
        }
        if (playerB.hasWon()) {
            return "Player B wins the game";
        }

        return "Player A: " +
                playerA.getScore().getValue() +
                " / " +
                "Player B: " +
                playerB.getScore().getValue();
    }
}
