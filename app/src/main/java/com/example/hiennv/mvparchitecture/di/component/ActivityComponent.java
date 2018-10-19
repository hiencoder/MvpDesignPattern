package com.example.hiennv.mvparchitecture.di.component;

import com.example.hiennv.mvparchitecture.di.module.ActivityModule;
import com.example.hiennv.mvparchitecture.di.scope.PerActivity;
import com.example.hiennv.mvparchitecture.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity splashActivity);
}
