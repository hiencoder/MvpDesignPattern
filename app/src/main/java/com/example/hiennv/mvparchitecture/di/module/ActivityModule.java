package com.example.hiennv.mvparchitecture.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.hiennv.mvparchitecture.di.scope.qualifier.ActivityContext;
import com.example.hiennv.mvparchitecture.di.scope.PerActivity;
import com.example.hiennv.mvparchitecture.ui.splash.SplashPresenterImpl;
import com.example.hiennv.mvparchitecture.ui.splash.SplashView;
import com.example.hiennv.mvparchitecture.utils.rx.AppSchedulers;
import com.example.hiennv.mvparchitecture.utils.rx.SchedulersProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/*Provide module level activity
* Context, Activity, PresenterImpl, Composite*/
@Module
public class ActivityModule {
    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    //Provide Context
    @Provides
    @ActivityContext
    public Context provideContext(){
        return activity;
    }

    //Provide AppCompatActivity
    @Provides
    public AppCompatActivity provideActivity(){
        return activity;
    }

    //Provide Schedulers
    @Provides
    public SchedulersProvider provideSchedulers(){
        return new AppSchedulers();
    }

    //Provide CompositeDisposable
    @Provides
    public CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    //Provide SplashPresenterImpl
    @Provides
    @PerActivity
    public SplashPresenterImpl<SplashView> provideSplashPresenterImpl(SplashPresenterImpl<SplashView> splashPresenterImpl){
        return splashPresenterImpl;
    }


}
