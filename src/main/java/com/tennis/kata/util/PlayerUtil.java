package com.tennis.kata.util;

public final class PlayerUtil {

    private PlayerUtil() {

    }

    public static String opponent (String playerId) {
        if ("A".equals(playerId)) {
            return "B";
        }
        if ("B".equals(playerId)) {
            return "A";
        }
        throw new IllegalArgumentException("Value " + playerId + "is not authorized");
    }
}
