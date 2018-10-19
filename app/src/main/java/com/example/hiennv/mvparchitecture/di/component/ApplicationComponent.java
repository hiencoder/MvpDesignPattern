package com.example.hiennv.mvparchitecture.di.component;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mvparchitecture.app.MyApplication;
import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.di.module.ApplicationModule;
import com.example.hiennv.mvparchitecture.di.scope.qualifier.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MyApplication myApplication);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
