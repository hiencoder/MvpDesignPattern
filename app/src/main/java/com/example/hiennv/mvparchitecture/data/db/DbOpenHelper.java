package com.example.hiennv.mvparchitecture.data.db;

import android.content.Context;

import com.example.hiennv.mvparchitecture.data.db.model.DaoMaster;
import com.example.hiennv.mvparchitecture.utils.AppLogger;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/*Create database*/
@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper{
    private static final String TAG = DbOpenHelper.class.getSimpleName();
    @Inject
    public DbOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        AppLogger.d(TAG,"OldVersion: " + oldVersion + ", newVersion: " + newVersion);
        switch (oldVersion){
            case 1:
                break;
            case 2:
                break;
        }
    }
}
