package com.learning.system;

/**
 * Created by karim on 4/21/20.
 */
public enum ErrorLogTypeKeys {
    INFO(0), WARN(1), ERROR(2);

    private final int type;

    private ErrorLogTypeKeys(int type) {
        this.type = type;
    }

    public int value() {
        return type;
    }

    public String toString() {
        return String.valueOf(type);
    }
}
