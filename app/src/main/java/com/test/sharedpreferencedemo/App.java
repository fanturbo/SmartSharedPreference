package com.test.sharedpreferencedemo;

import android.app.Application;

public class App extends Application {

    private static App mInstance;

    public static App geInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
