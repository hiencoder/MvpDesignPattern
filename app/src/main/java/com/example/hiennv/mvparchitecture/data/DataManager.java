package com.example.hiennv.mvparchitecture.data;

import com.example.hiennv.mvparchitecture.data.db.DbHelper;

public interface DataManager extends DbHelper{
    enum LoggedInMode{
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int type;
        LoggedInMode(int type){
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
