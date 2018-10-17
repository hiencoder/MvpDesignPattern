package com.example.hiennv.mvparchitecture.ui.splash;

import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.di.scope.PerActivity;
import com.example.hiennv.mvparchitecture.ui.base.BasePresenterImpl;
import com.example.hiennv.mvparchitecture.utils.rx.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenterImpl<V extends SplashContract.SplashView> extends BasePresenterImpl<V>
        implements SplashContract.SplashPresenter<V>{

    @Inject
    public SplashPresenterImpl(DataManager dataManager,
                               SchedulersProvider schedulersProvider,
                               CompositeDisposable compositeDisposable) {
        super(dataManager, schedulersProvider, compositeDisposable);

    }

    @Override
    public void onAttach(V baseView) {
        super.onAttach(baseView);

    }


}
