package com.example.hiennv.mvparchitecture.ui.splash;

import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.ui.base.BasePresenterImpl;
import com.example.hiennv.mvparchitecture.utils.rx.SchedulersProvider;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class SplashPresenterImpl<V extends SplashView> extends BasePresenterImpl<V>
        implements SplashPresenter<V> {

    @Inject
    public SplashPresenterImpl(DataManager dataManager,
                               SchedulersProvider schedulersProvider,
                               CompositeDisposable compositeDisposable) {
        super(dataManager, schedulersProvider, compositeDisposable);

    }

    @Override
    public void onAttach(V baseView) {
        super.onAttach(baseView);
        getBaseView().startService();

        getCompositeDisposable().add(getDataManager()
                .seedDatabaseQuestions()
                .subscribeOn(getSchedulersProvider().io())
                .observeOn(getSchedulersProvider().ui())
                .concatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Boolean aBoolean) throws Exception {
                        return getDataManager().seedDatabaseOptions();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttach()) {
                            return;
                        }
                        decideNextActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttach()) {
                            return;
                        }
                        getBaseView().onError("Error");
                        decideNextActivity();
                    }
                }));
    }

    private void decideNextActivity() {
        if (getDataManager().getCurrentUserLoggedMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            //Open login activity
            getBaseView().openLoginActivity();
        } else {
            //Open MainActivity
            getBaseView().openMainActivity();
        }
    }


}
