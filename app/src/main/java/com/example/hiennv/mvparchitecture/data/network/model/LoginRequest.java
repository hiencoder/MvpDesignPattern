package com.example.hiennv.mvparchitecture.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    public LoginRequest() {
    }

    public class ServerLoginRequest {
        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        public ServerLoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public ServerLoginRequest() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof ServerLoginRequest))
                return false;
            ServerLoginRequest serverLoginRequest = (ServerLoginRequest) obj;
            if (!email.equals(serverLoginRequest.email))
                return false;
            return password.equals(serverLoginRequest.password);
        }

        @Override
        public int hashCode() {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }
    }

    public class FacebookLoginRequest {
        @Expose
        @SerializedName("fb_user_id")
        private String fbUserId;

        @Expose
        @SerializedName("fb_access_token")
        private String fbAccessToken;

        public FacebookLoginRequest(String fbUserId, String fbAccessToken) {
            this.fbUserId = fbUserId;
            this.fbAccessToken = fbAccessToken;
        }

        public String getFbUserId() {
            return fbUserId;
        }

        public void setFbUserId(String fbUserId) {
            this.fbUserId = fbUserId;
        }

        public String getFbAccessToken() {
            return fbAccessToken;
        }

        public void setFbAccessToken(String fbAccessToken) {
            this.fbAccessToken = fbAccessToken;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            FacebookLoginRequest facebookLoginRequest = (FacebookLoginRequest) obj;
            if (!fbUserId.equals(facebookLoginRequest.fbUserId))
                return false;
            return fbAccessToken.equals(facebookLoginRequest.fbAccessToken);
        }

        @Override
        public int hashCode() {
            int result = fbUserId != null ? fbUserId.hashCode() : 0;
            result = 31 * result + (fbAccessToken != null ? fbAccessToken.hashCode() : 0);
            return result;
        }
    }

    public class GoogleLoginRequest {
        @Expose
        @SerializedName("google_user_id")
        private String googleUserId;

        @Expose
        @SerializedName("google_id_token")
        private String googleIdToken;

        public GoogleLoginRequest(String googleUserId, String googleIdToken) {
            this.googleUserId = googleUserId;
            this.googleIdToken = googleIdToken;
        }

        public GoogleLoginRequest() {
        }

        public String getGoogleUserId() {
            return googleUserId;
        }

        public void setGoogleUserId(String googleUserId) {
            this.googleUserId = googleUserId;
        }

        public String getGoogleIdToken() {
            return googleIdToken;
        }

        public void setGoogleIdToken(String googleIdToken) {
            this.googleIdToken = googleIdToken;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof GoogleLoginRequest))
                return false;
            GoogleLoginRequest googleLoginRequest = (GoogleLoginRequest) obj;
            if(!googleUserId.equals(googleLoginRequest.googleUserId))
                return false;
            return googleIdToken.equals(googleLoginRequest.googleIdToken);
        }

        @Override
        public int hashCode() {
            int result = googleUserId != null ? googleUserId.hashCode() : 0;
            result = 31 * result + (googleIdToken != null ? googleIdToken.hashCode() : 0);
            return result;
        }
    }
}
