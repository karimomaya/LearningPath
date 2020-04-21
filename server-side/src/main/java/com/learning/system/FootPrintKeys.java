package com.learning.system;

/**
 * Created by karim on 4/18/20.
 */
public enum FootPrintKeys {
    CREATE(1), UPDATE(2), DELETE(3);

    private final int cat;

    private FootPrintKeys(int cat) {
        this.cat = cat;
    }

    public int value() {
        return cat;
    }

    public Long val(){
        return  new Long(cat);
    }

    public String toString() {
        return String.valueOf(cat);
    }
}
