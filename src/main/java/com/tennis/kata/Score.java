package com.tennis.kata;

public enum Score {

    ZERO("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("A"),
    WIN("W");

    private final String value;

    Score(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


