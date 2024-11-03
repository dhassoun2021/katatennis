package com.tennis.kata.validator;

import com.tennis.kata.exceptions.InvalidCommandException;

public class CommandValidator {


    /**
     * Validate command validity
     * @param command
     */
    public void  validate (String command) {
        if (command == null || command.isBlank()) {
            throw new InvalidCommandException("Command parameter must not be empty!");
        }
        if (!command.matches("([AB]+)")){
            throw new InvalidCommandException("Command parameter should contain only A or B !");
        }
    }
}
