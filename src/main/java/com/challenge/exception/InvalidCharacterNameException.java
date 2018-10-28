package com.challenge.exception;

public class InvalidCharacterNameException extends RuntimeException {

    public InvalidCharacterNameException(final String message) {
        super(message);
    }

}