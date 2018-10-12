package com.example.hiennv.mvparchitecture.ui.base;

import com.androidnetworking.error.ANError;
import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.utils.rx.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V>{
    public static final String TAG = BasePresenterImpl.class.getSimpleName();
    private V mBaseView;
    private final DataManager dataManager;
    private final SchedulersProvider schedulersProvider;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public BasePresenterImpl(DataManager dataManager, SchedulersProvider schedulersProvider,CompositeDisposable compositeDisposable){
        this.dataManager = dataManager;
        this.schedulersProvider = schedulersProvider;
        this.compositeDisposable = compositeDisposable;
    }
    @Override
    public void onAttach(V baseView) {
        mBaseView = baseView;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void handleApiError(ANError error) {

    }

    @Override
    public void setUserAsLogout() {

    }
}
