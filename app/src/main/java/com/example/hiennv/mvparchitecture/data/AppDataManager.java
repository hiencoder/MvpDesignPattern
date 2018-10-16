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
import com.example.hiennv.mvparchitecture.di.scope.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

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
        apiHelper.getApiHelper().getProtectApiHeader().setUserId(userId);
        apiHelper.getApiHelper().getProtectApiHeader().setAccessToken(accessToken);
    }

    @Override
    public void setUserLogout() {

    }

    @Override
    public Observable<Boolean> seedDatabaseQuestions() {
        return null;
    }

    @Override
    public Observable<Boolean> seedDatabaseOptions() {
        return null;
    }

    @Override
    public void updateUserInfo(String accessToken, Long userId, LoggedInMode loggedInMode, String userName, String email, String profilePic) {

    }

    @Override
    public ApiHeader getApiHelper() {
        return null;
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest googleLoginRequest) {
        return null;
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest facebookLoginRequest) {
        return null;
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest serverLoginRequest) {
        return null;
    }

    @Override
    public Single<LogoutResponse> doLogouApiCall() {
        return null;
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return null;
    }

    @Override
    public Single<OpenSoureResponse> getOpenSourcApiCall() {
        return null;
    }

    @Override
    public int getCurrentUserLoggedMode() {
        return 0;
    }

    @Override
    public void setCurrentUserLoggedMode(LoggedInMode loggedMode) {

    }

    @Override
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    public void setCurrentUserId(Long userId) {

    }

    @Override
    public String getCurrentUserName() {
        return null;
    }

    @Override
    public void setCurrentUserName(String userName) {

    }

    @Override
    public String getCurrentUserEmail() {
        return null;
    }

    @Override
    public void setCurrentUserEmail(String userEmail) {

    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return null;
    }

    @Override
    public void setCurrentUserProfilePicUrl(String picUrl) {

    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
