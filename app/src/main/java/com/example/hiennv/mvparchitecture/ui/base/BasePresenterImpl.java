package com.example.hiennv.mvparchitecture.ui.base;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.error.ANError;
import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.data.network.model.ApiError;
import com.example.hiennv.mvparchitecture.utils.AppConstants;
import com.example.hiennv.mvparchitecture.utils.rx.SchedulersProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.net.HttpURLConnection;

import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    public static final String TAG = BasePresenterImpl.class.getSimpleName();
    private V mBaseView;
    private final DataManager dataManager;
    private final SchedulersProvider schedulersProvider;
    private final CompositeDisposable compositeDisposable;

    @Inject
    public BasePresenterImpl(DataManager dataManager, SchedulersProvider schedulersProvider, CompositeDisposable compositeDisposable) {
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
        compositeDisposable.dispose();
        mBaseView = null;
    }

    public boolean isViewAttach() {
        return mBaseView != null;
    }

    @Override
    public void handleApiError(ANError error) {
        if (error == null || error.getErrorBody() == null) {
            mBaseView.onError("Something wrong happened!");
            return;
        }

        //network error
        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR
                && error.getErrorDetail().equals(ANConstants.CONNECTION_ERROR)) {
            mBaseView.onError("Internet connection lost");
            return;
        }

        if (error.getErrorCode() == AppConstants.API_STATUS_CODE_LOCAL_ERROR
                && error.getErrorDetail().equals(ANConstants.REQUEST_CANCELLED_ERROR)) {
            mBaseView.onError("Please retry!");
            return;
        }

        GsonBuilder gsonBuilder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        Gson gson = gsonBuilder.create();

        try {

            ApiError apiError = gson.fromJson(error.getErrorBody(), ApiError.class);
            if (apiError == null || apiError.getMessage() == null){
                getBaseView().onError("Something wrong happened!");
                return;
            }

            switch (error.getErrorCode()){
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                case HttpURLConnection.HTTP_FORBIDDEN:
                    setUserAsLogout();
                    getBaseView().openActivityOnTokenExpire();
                case HttpURLConnection.HTTP_INTERNAL_ERROR:
                case HttpURLConnection.HTTP_NOT_FOUND:
                    default:
                        getBaseView().onError("Something wrong happened!");
            }

        }catch (JsonSyntaxException | NullPointerException e){

        }

    }

    @Override
    public void setUserAsLogout() {
        getDataManager().setUserLogout();
    }

    public V getBaseView() {
        return mBaseView;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public SchedulersProvider getSchedulersProvider() {
        return schedulersProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
