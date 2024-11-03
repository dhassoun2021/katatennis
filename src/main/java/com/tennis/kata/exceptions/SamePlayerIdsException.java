package com.tennis.kata.exceptions;

public class SamePlayerIdsException extends RuntimeException{

    public SamePlayerIdsException (String message) {
        super(message);
    }
}
