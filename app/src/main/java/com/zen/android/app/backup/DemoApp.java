package com.zen.android.app.backup;

import android.app.Application;

/**
 * DemoApp
 *
 * @author zeny
 * @version 2015.11.29
 */
public class DemoApp extends Application {

    private static Integer sValue;

    public static void setValue(Integer value) {
        sValue = value;
    }

    public static Integer getValue() {
        return sValue;
    }

}
