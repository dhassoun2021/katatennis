package com.tennis.kata.display;

import com.tennis.kata.Player;
import com.tennis.kata.Players;

import static com.tennis.kata.Players.ID_PLAYER_A;
import static com.tennis.kata.Players.ID_PLAYER_B;

/**
 * This class has responsibility to format Players to simple text
 */
public class GameTextFormater implements GameFormater {

    @Override
    public String format(Players players) {
        Player playerA = players.getPlayer(ID_PLAYER_A);
        Player playerB = players.getPlayer(ID_PLAYER_B);
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
