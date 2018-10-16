package com.example.hiennv.mvparchitecture.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {
    private ProtectApiHeader protectApiHeader;
    private PublicApiHeader publicApiHeader;

    @Inject
    public ApiHeader(ProtectApiHeader protectApiHeader, PublicApiHeader publicApiHeader){
        this.protectApiHeader = protectApiHeader;
        this.publicApiHeader = publicApiHeader;
    }

    public ProtectApiHeader getProtectApiHeader() {
        return protectApiHeader;
    }

    public PublicApiHeader getPublicApiHeader() {
        return publicApiHeader;
    }

    public static final class PublicApiHeader{
        @Expose
        @SerializedName("api_key")
        private String apiKey;

        public PublicApiHeader(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }
    public static final class ProtectApiHeader{
        @Expose
        @SerializedName("api_key")
        private String apiKey;

        @Expose
        @SerializedName("user_id")
        private Long userId;

        @Expose
        @SerializedName("access_token")
        private String accessToken;

        public ProtectApiHeader(String apiKey, Long userId, String accessToken) {
            this.apiKey = apiKey;
            this.userId = userId;
            this.accessToken = accessToken;
        }

        public ProtectApiHeader() {
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }


    }
}
