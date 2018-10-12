package com.example.hiennv.mvparchitecture.ui.main;

import com.example.hiennv.mvparchitecture.ui.base.BasePresenter;
import com.example.hiennv.mvparchitecture.ui.base.BaseView;

public interface MainContract {
    interface MainView extends BaseView{

    }

    interface MainPresenter<V extends MainView> extends BasePresenter<V>{

    }
}
