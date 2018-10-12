package com.example.hiennv.mvparchitecture.ui.base;

import android.support.annotation.StringRes;

public interface BaseView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int message);

    boolean isNetworkConnected();

    void hideKeyboard();
}
