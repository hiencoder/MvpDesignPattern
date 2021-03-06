package com.example.hiennv.mvparchitecture.data;

import android.content.Context;

import com.example.hiennv.mvparchitecture.data.db.DbHelper;
import com.example.hiennv.mvparchitecture.data.db.model.Option;
import com.example.hiennv.mvparchitecture.data.db.model.Question;
import com.example.hiennv.mvparchitecture.data.db.model.User;
import com.example.hiennv.mvparchitecture.data.network.ApiHeader;
import com.example.hiennv.mvparchitecture.data.network.ApiHelper;
import com.example.hiennv.mvparchitecture.data.network.model.BlogResponse;
import com.example.hiennv.mvparchitecture.data.network.model.LoginRequest;
import com.example.hiennv.mvparchitecture.data.network.model.LoginResponse;
import com.example.hiennv.mvparchitecture.data.network.model.LogoutResponse;
import com.example.hiennv.mvparchitecture.data.network.model.OpenSoureResponse;
import com.example.hiennv.mvparchitecture.data.pref.PrefHelper;
import com.example.hiennv.mvparchitecture.di.scope.qualifier.ApplicationContext;
import com.example.hiennv.mvparchitecture.utils.Common;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/*Lam viec voi database: */
public class AppDataManager implements DataManager {
    private static final String TAG = AppDataManager.class.getSimpleName();

    private final Context context;
    private final DbHelper dbHelper;
    private final PrefHelper prefHelper;
    private final ApiHelper apiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, PrefHelper prefHelper, ApiHelper apiHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.prefHelper = prefHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public Observable<Long> insertUser(User user) {
        return dbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUser() {
        return dbHelper.getAllUser();
    }

    @Override
    public Observable<List<Question>> getAllQuestion() {
        return dbHelper.getAllQuestion();
    }

    @Override
    public Observable<Boolean> isQuestionEmpty() {
        return dbHelper.isQuestionEmpty();
    }

    @Override
    public Observable<Boolean> isOptionEmpty() {
        return dbHelper.isOptionEmpty();
    }

    @Override
    public Observable<Boolean> saveQuestion(Question question) {
        return dbHelper.saveQuestion(question);
    }

    @Override
    public Observable<Boolean> saveOption(Option option) {
        return dbHelper.saveOption(option);
    }

    @Override
    public Observable<Boolean> saveQuestionList(List<Question> questions) {
        return dbHelper.saveQuestionList(questions);
    }

    @Override
    public Observable<Boolean> saveOptionList(List<Option> options) {
        return dbHelper.saveOptionList(options);
    }

    @Override
    public void updateApiHelper(Long userId, String accessToken) {
        apiHelper.getApiHeader().getProtectApiHeader().setUserId(userId);
        apiHelper.getApiHeader().getProtectApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void setUserLogout() {

    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {
        return dbHelper.isQuestionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty) throws Exception {
                        if (isEmpty){
                            List<Question> list = Common.parseListQuestion(context);
                            return saveQuestionList(list);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {
        return dbHelper.isOptionEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty) throws Exception {
                        if (isEmpty){
                            List<Option> list = Common.parseListOption(context);
                            return saveOptionList(list);
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String userName, String email, String profilePic) {
        setAccessToken(accessToken);
        setCurrentUserId(userId);
        setCurrentUserLoggedMode(loggedInMode);
        setCurrentUserName(userName);
        setCurrentUserEmail(email);
        setCurrentUserProfilePicUrl(profilePic);
    }

    @Override
    public ApiHeader getApiHeader() {
        return apiHelper.getApiHeader();
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest googleLoginRequest) {
        return apiHelper.doGoogleLoginApiCall(googleLoginRequest);
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest facebookLoginRequest) {
        return apiHelper.doFacebookLoginApiCall(facebookLoginRequest);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest serverLoginRequest) {
        return apiHelper.doServerLoginApiCall(serverLoginRequest);
    }

    @Override
    public Single<LogoutResponse> doLogouApiCall() {
        return apiHelper.doLogouApiCall();
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return apiHelper.getBlogApiCall();
    }

    @Override
    public Single<OpenSoureResponse> getOpenSourcApiCall() {
        return apiHelper.getOpenSourcApiCall();
    }

    @Override
    public int getCurrentUserLoggedMode() {
        return prefHelper.getCurrentUserLoggedMode();
    }

    @Override
    public void setCurrentUserLoggedMode(LoggedInMode loggedMode) {
        prefHelper.setCurrentUserLoggedMode(loggedMode);
    }

    @Override
    public Long getCurrentUserId() {
        return prefHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        prefHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return prefHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String userName) {
        prefHelper.setCurrentUserName(userName);
    }

    @Override
    public String getCurrentUserEmail() {
        return prefHelper.getCurrentUserEmail();
    }

    @Override
    public void setCurrentUserEmail(String userEmail) {
        prefHelper.setCurrentUserEmail(userEmail);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return prefHelper.getCurrentUserProfilePicUrl();
    }

    @Override
    public void setCurrentUserProfilePicUrl(String picUrl) {
        prefHelper.setCurrentUserProfilePicUrl(picUrl);
    }

    @Override
    public String getAccessToken() {
        return prefHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        prefHelper.setAccessToken(accessToken);
    }
}
