package com.learning.system.exception;

/**
 * Created by karim on 4/17/20.
 */
public class AlreadyExistException extends Exception {

    public AlreadyExistException(String message) {
        super(message);
    }

    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
