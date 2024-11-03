package com.tennis.kata;

public final class PlayerUtil {

    private PlayerUtil () {

    }

    public static String opposite (String playerName) {
        if ("A".equals(playerName)) {
            return "B";
        }
        return "A";
    }
}
