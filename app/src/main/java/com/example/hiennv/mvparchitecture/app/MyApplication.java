package com.example.hiennv.mvparchitecture.app;

import android.app.Application;

import com.example.hiennv.mvparchitecture.utils.AppLogger;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AppLogger.init();
    }
}
