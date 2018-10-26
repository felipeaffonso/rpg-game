package com.challenge.exception;

public class DeadCharacterException extends RuntimeException {

    public DeadCharacterException(final String message) {
        super(message);
    }

}