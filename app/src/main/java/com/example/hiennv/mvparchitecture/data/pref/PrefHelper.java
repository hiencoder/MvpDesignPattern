package com.example.hiennv.mvparchitecture.data.pref;

import com.example.hiennv.mvparchitecture.data.DataManager;

public interface PrefHelper {
    int getCurrentUserLoggedMode();

    void setCurrentUserLoggedMode(DataManager.LoggedInMode loggedMode);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String userEmail);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String picUrl);

    String getAccessToken();

    void setAccessToken(String accessToken);
}
