package com.example.hiennv.mvparchitecture.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.di.scope.ApplicationContext;
import com.example.hiennv.mvparchitecture.di.scope.PreferenceInfo;
import com.example.hiennv.mvparchitecture.utils.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PrefHelper {
    public static final String PREF_KEY_USER_LOGGED_MODE = "PREF_KEY_USER_LOGGED_MODE";
    public static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    public static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    public static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    public static final String PREF_KEY_CURRENT_USER_PROFILE = "PREF_KEY_CURRENT_USER_PROFILE";
    public static final String PREF_KEY_CURRENT_ACCESS_TOKEN = "PREF_KEY_CURRENT_ACCESS_TOKEN";

    private final SharedPreferences sharedPreferences;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    @Override
    public int getCurrentUserLoggedMode() {
        return sharedPreferences.getInt(PREF_KEY_USER_LOGGED_MODE, DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedMode(DataManager.LoggedInMode loggedMode) {
        sharedPreferences.edit().putInt(PREF_KEY_USER_LOGGED_MODE, loggedMode.getType()).commit();
    }

    @Override
    public Long getCurrentUserId() {
        long userId = sharedPreferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return (userId == AppConstants.NULL_INDEX) ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        sharedPreferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, userId).commit();
    }

    @Override
    public String getCurrentUserName() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).commit();
    }

    @Override
    public String getCurrentUserEmail() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_EMAIL, null);
    }

    @Override
    public void setCurrentUserEmail(String userEmail) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, userEmail).commit();
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_PROFILE, null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String picUrl) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_PROFILE, picUrl).commit();
    }

    @Override
    public String getAccessToken() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_ACCESS_TOKEN,null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_ACCESS_TOKEN,accessToken).commit();
    }
}
