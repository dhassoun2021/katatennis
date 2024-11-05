package com.tennis.kata.validator;

public final class CommandValidator {

    private CommandValidator () {

    }

    public static void  validate (String command) {
        if (command == null || command.isBlank()) {
            throw new IllegalArgumentException("Command parameter must not be empty!");
        }
        if (!command.matches("([AB]+)")){
            throw new IllegalArgumentException("Command parameter should contain only A or B !");
        }
    }
}
