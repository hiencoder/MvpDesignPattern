package com.example.hiennv.mvparchitecture.data.network;

import com.example.hiennv.mvparchitecture.data.network.model.BlogResponse;
import com.example.hiennv.mvparchitecture.data.network.model.LoginRequest;
import com.example.hiennv.mvparchitecture.data.network.model.LoginResponse;
import com.example.hiennv.mvparchitecture.data.network.model.LogoutResponse;
import com.example.hiennv.mvparchitecture.data.network.model.OpenSoureResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppApiHelper implements ApiHelper {
    private ApiHeader apiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        this.apiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHelper() {
        return this.apiHeader;
    }

    @Override
    public Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest googleLoginRequest) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(apiHeader.getPublicApiHeader())
                .addBodyParameter(googleLoginRequest)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest facebookLoginRequest) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(apiHeader.getPublicApiHeader())
                .addBodyParameter(facebookLoginRequest)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest serverLoginRequest) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(apiHeader.getPublicApiHeader())
                .addBodyParameter(serverLoginRequest)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LogoutResponse> doLogouApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(apiHeader.getProtectApiHeader())
                .build()
                .getObjectSingle(LogoutResponse.class);
    }

    @Override
    public Single<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(apiHeader.getPublicApiHeader())
                .build()
                .getObjectSingle(BlogResponse.class);
    }

    @Override
    public Single<OpenSoureResponse> getOpenSourcApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(apiHeader.getPublicApiHeader())
                .build()
                .getObjectSingle(OpenSoureResponse.class);
    }
}
