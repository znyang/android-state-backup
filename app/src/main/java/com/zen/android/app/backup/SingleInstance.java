package com.zen.android.app.backup;

/**
 * SingleInstance
 *
 * @author zeny
 * @version 2015.11.29
 */
public enum SingleInstance {

    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
