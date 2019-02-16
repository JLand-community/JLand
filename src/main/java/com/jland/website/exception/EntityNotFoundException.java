package com.jland.website.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message) {
        this(message, null);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
