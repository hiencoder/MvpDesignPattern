package com.example.hiennv.mvparchitecture.ui.splash;

import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.di.scope.PerActivity;
import com.example.hiennv.mvparchitecture.ui.base.BasePresenterImpl;
import com.example.hiennv.mvparchitecture.utils.rx.SchedulersProvider;

import io.reactivex.disposables.CompositeDisposable;

@PerActivity
public class SplashPresenterImpl<V extends SplashContract.SplashView> extends BasePresenterImpl<V> {

    public SplashPresenterImpl(DataManager dataManager, SchedulersProvider schedulersProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulersProvider, compositeDisposable);
    }
}
