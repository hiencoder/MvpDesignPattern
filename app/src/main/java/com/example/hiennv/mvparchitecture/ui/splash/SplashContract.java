package com.example.hiennv.mvparchitecture.ui.splash;

import com.example.hiennv.mvparchitecture.di.scope.PerActivity;
import com.example.hiennv.mvparchitecture.ui.base.BasePresenter;
import com.example.hiennv.mvparchitecture.ui.base.BaseView;

public interface SplashContract {
    interface SplashView extends BaseView {
        void openLoginActivity();

        void openMainActivity();

        void startService();
    }

    @PerActivity
    interface SplashPresenter<V extends SplashView> extends BasePresenter<V>{

    }
}
