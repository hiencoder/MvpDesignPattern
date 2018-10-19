package com.example.hiennv.mvparchitecture.ui.splash;


import android.os.Bundle;

import com.example.hiennv.mvparchitecture.R;
import com.example.hiennv.mvparchitecture.ui.base.BaseActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView{

    @Inject
    SplashPresenter<SplashView> splashPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {

    }

    @Override
    public void startService() {

    }
}
