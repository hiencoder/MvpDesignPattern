package com.example.hiennv.mvparchitecture.data;

import com.example.hiennv.mvparchitecture.data.db.DbHelper;
import com.example.hiennv.mvparchitecture.data.network.ApiHelper;
import com.example.hiennv.mvparchitecture.data.pref.PrefHelper;

import io.reactivex.Observable;

public interface DataManager extends DbHelper, PrefHelper, ApiHelper {
    void updateApiHelper(Long userId, String accessToken);

    void setUserLogout();

    Observable<Boolean> seedDatabaseQuestions();

    Observable<Boolean> seedDatabaseOptions();

    void updateUserInfo(String accessToken,
                        Long userId,
                        LoggedInMode loggedInMode,
                        String userName,
                        String email,
                        String profilePic);

    enum LoggedInMode {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int type;

        LoggedInMode(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
