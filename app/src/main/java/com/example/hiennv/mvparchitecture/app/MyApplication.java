package com.example.hiennv.mvparchitecture.app;

import android.app.Application;

import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.di.component.ApplicationComponent;
import com.example.hiennv.mvparchitecture.utils.AppLogger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application {
    @Inject
    DataManager dataManager;
    @Inject
    CalligraphyConfig calligraphyConfig;

    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        AppLogger.init();
        //applicationComponent =
    }
}
