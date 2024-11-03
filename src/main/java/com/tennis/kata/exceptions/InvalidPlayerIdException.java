package com.tennis.kata.exceptions;

public class InvalidPlayerIdException extends RuntimeException{

    public InvalidPlayerIdException (String message) {
        super(message);
    }
}
