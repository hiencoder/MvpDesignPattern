package com.example.hiennv.mvparchitecture.ui.base;

public interface SubBaseView extends BaseView {
    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onAttachParentBaseView(BaseView baseView);
}
