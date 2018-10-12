package com.example.hiennv.mvparchitecture.ui.base;

import com.androidnetworking.error.ANError;

public interface BasePresenter<V extends BaseView> {
    void onAttach(V baseView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLogout();

}
