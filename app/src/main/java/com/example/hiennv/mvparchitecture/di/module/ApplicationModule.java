package com.example.hiennv.mvparchitecture.di.module;

import android.app.Application;
import android.content.Context;

import com.example.hiennv.mvparchitecture.BuildConfig;
import com.example.hiennv.mvparchitecture.R;
import com.example.hiennv.mvparchitecture.data.AppDataManager;
import com.example.hiennv.mvparchitecture.data.DataManager;
import com.example.hiennv.mvparchitecture.data.db.AppDbHelper;
import com.example.hiennv.mvparchitecture.data.db.DbHelper;
import com.example.hiennv.mvparchitecture.data.network.ApiHeader;
import com.example.hiennv.mvparchitecture.data.network.ApiHelper;
import com.example.hiennv.mvparchitecture.data.network.AppApiHelper;
import com.example.hiennv.mvparchitecture.data.pref.AppPreferencesHelper;
import com.example.hiennv.mvparchitecture.data.pref.PrefHelper;
import com.example.hiennv.mvparchitecture.di.scope.qualifier.ApiInfo;
import com.example.hiennv.mvparchitecture.di.scope.qualifier.ApplicationContext;
import com.example.hiennv.mvparchitecture.di.scope.qualifier.DatabaseInfo;
import com.example.hiennv.mvparchitecture.di.scope.qualifier.PreferenceInfo;
import com.example.hiennv.mvparchitecture.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/*Provide component leve app
* Provide: SharedPrefHelper, DbHelper, ApiHelper,
* Lib font Calligraphy*/
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    //Provide Context
    @Provides
    @ApplicationContext
    public Context provideApplicationContext(){
        return application;
    }

    //Provide Application
    @Provides
    public Application provideApplication(){
        return application;
    }

    //Provide Database name
    @Provides
    @DatabaseInfo
    public String provideDatabseName(){
        return AppConstants.DATABASE_NAME;
    }

    //Provide ApiKey
    @Provides
    @ApiInfo
    public String provideApiKey(){
        return BuildConfig.API_KEY;
    }

    //Provide file PreferenceName
    @Provides
    @PreferenceInfo
    public String providePreferenceName(){
        return AppConstants.SHARED_NAME;
    }

    //Provide Datamanager
    @Provides
    @Singleton
    public DataManager provideDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    //Provide DbHelper
    @Provides
    @Singleton
    public DbHelper provideDbHelper(AppDbHelper appDbHelper){
        return appDbHelper;
    }

    //Provide AppPrefHelper
    @Provides
    @Singleton
    public PrefHelper provideAppPrefHelper(AppPreferencesHelper appPreferencesHelper){
        return appPreferencesHelper;
    }

    //Provide APiHelper
    @Provides
    @Singleton
    public ApiHelper provideApiHelper(AppApiHelper appApiHelper){
        return appApiHelper;
    }

    //Provide ProtectApiHeader
    @Provides
    @Singleton
    public ApiHeader.ProtectApiHeader provideProtectApiHeader(@ApiInfo String apiKey, PrefHelper prefHelper){
        return new ApiHeader.ProtectApiHeader(apiKey,
                prefHelper.getCurrentUserId(),
                prefHelper.getAccessToken());
    }

    //Provide CalligraphyConfig
    @Provides
    @Singleton
    public CalligraphyConfig provideCalligraphyConfig(){
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
