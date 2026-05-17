package com.agenda.common.exception;

public class EventRepositoryException extends RuntimeException {
    public EventRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
