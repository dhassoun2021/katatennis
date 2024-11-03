package com.tennis.kata;

import com.tennis.kata.exceptions.InvalidPlayerIdException;
import com.tennis.kata.validator.PlayerIdValidator;

import java.util.Objects;

/**
 * This class encapsulate 2 players playing a tennis match
 */
public class Players {

    public static final String ID_PLAYER_A = "A";
    public static final String ID_PLAYER_B = "B";

    private final Player playerA;
    private final Player playerB;

    private Players() {
        this.playerA = Player.of(ID_PLAYER_A);
        this.playerB = Player.of(ID_PLAYER_B);
        PlayerIdValidator.validateNotSameId(playerA.getId(), playerB.getId());
    }

    private Players(Score scoreA, Score scoreB) {
        this.playerA = Player.of(ID_PLAYER_A, scoreA);
        this.playerB = Player.of(ID_PLAYER_B, scoreB);
        PlayerIdValidator.validateNotSameId(playerA.getId(), playerB.getId());
    }

    public static Players of (Score scoreA, Score scoreB) {
        return new Players(scoreA, scoreB);
    }

    public static Players create() {
        return new Players();
    }

    public Player getPlayer (String playerId) {
        if (Objects.equals(playerId, playerA.getId())) {
            return playerA;
        }
        if (Objects.equals(playerId, playerB.getId())) {
            return playerB;
        }
        throw new InvalidPlayerIdException("No players found with id "+ playerId);
    }

    public Player getOpponent (String playerId) {
        if (Objects.equals(playerId, playerA.getId())) {
            return playerB;
        }
        if (Objects.equals(playerId, playerB.getId())) {
            return playerA;
        }
        throw new InvalidPlayerIdException("No players found with id "+ playerId);
    }


    public boolean onePlayerHasWon () {
        return (playerA.hasWon() || playerB.hasWon());
    }


}
