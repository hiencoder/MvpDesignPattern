package com.example.hiennv.mvparchitecture.data.network;

import com.example.hiennv.mvparchitecture.data.network.model.BlogResponse;
import com.example.hiennv.mvparchitecture.data.network.model.LoginRequest;
import com.example.hiennv.mvparchitecture.data.network.model.LoginResponse;
import com.example.hiennv.mvparchitecture.data.network.model.LogoutResponse;
import com.example.hiennv.mvparchitecture.data.network.model.OpenSoureResponse;

import io.reactivex.Single;

public interface ApiHelper {
    ApiHeader getApiHelper();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest googleLoginRequest);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest facebookLoginRequest);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest serverLoginRequest);

    Single<LogoutResponse> doLogouApiCall();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSoureResponse> getOpenSourcApiCall();
}
