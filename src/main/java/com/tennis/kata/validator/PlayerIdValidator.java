package com.tennis.kata.validator;

import com.tennis.kata.exceptions.InvalidPlayerIdException;
import com.tennis.kata.exceptions.SamePlayerIdsException;

import java.util.Objects;
import java.util.Set;

public final class PlayerIdValidator {

    private static final Set<String> authorizedIds = Set.of("A","B");

    private PlayerIdValidator () {

    }
    /**
     * Validate id player has only authorized value
     * @param idPlayer idPlayer
     */
    public static void validatePlayerId (String idPlayer) throws InvalidPlayerIdException{
        if (!authorizedIds.contains(idPlayer)) {
            throw new InvalidPlayerIdException("Id player should have only values as " + authorizedIds);
        }
    }

    /**
     * Validate id between 2 players are not the same
     * @param idPlayerA idPlayerA
     * @param idPlayerB idPlayerB
     */
    public static void validateNotSameId (String idPlayerA, String idPlayerB) throws SamePlayerIdsException{
        if (Objects.equals(idPlayerA, idPlayerB)) {
            throw new SamePlayerIdsException("Players ids should be different");
        }
    }
}
