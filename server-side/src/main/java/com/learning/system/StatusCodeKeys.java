package com.learning.system;

/**
 * Created by karim on 4/18/20.
 */
public enum StatusCodeKeys {
    SUCCESS(200), BAD_REQUEST(500), CONFLICT(409), EMAIL_CONFLICT(410);

    private final int statusCode;

    private StatusCodeKeys(int code) {
        this.statusCode = code;
    }

    public int value() {
        return statusCode;
    }

    public String toString() {
        return String.valueOf(statusCode);
    }
}
