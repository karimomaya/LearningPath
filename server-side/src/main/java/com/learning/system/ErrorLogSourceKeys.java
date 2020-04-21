package com.learning.system;

/**
 * Created by karim on 4/21/20.
 */
public enum ErrorLogSourceKeys {
    BACKEND(false), FRONTEND(true);

    private final boolean type;

    private ErrorLogSourceKeys(boolean type) {
        this.type = type;
    }

    public boolean value() {
        return type;
    }

    public String toString() {
        return String.valueOf(type);
    }
}
