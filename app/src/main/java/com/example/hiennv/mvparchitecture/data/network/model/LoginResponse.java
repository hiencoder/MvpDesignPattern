package com.example.hiennv.mvparchitecture.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("user_id")
    private Long userId;

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("email")
    private String userEmail;

    @Expose
    @SerializedName("server_profile_pic_url")
    private String profilePic;

    @Expose
    @SerializedName("fb_profile_pic_url")
    private String fbProfilePic;

    @Expose
    @SerializedName("google_profile_pic_url")
    private String ggProfilePic;

    @Expose
    @SerializedName("message")
    private String message;

    public LoginResponse(String statusCode, Long userId, String accessToken, String userName, String userEmail,
                         String profilePic, String fbProfilePic, String ggProfilePic, String message) {
        this.statusCode = statusCode;
        this.userId = userId;
        this.accessToken = accessToken;
        this.userName = userName;
        this.userEmail = userEmail;
        this.profilePic = profilePic;
        this.fbProfilePic = fbProfilePic;
        this.ggProfilePic = ggProfilePic;
        this.message = message;
    }

    public LoginResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getFbProfilePic() {
        return fbProfilePic;
    }

    public void setFbProfilePic(String fbProfilePic) {
        this.fbProfilePic = fbProfilePic;
    }

    public String getGgProfilePic() {
        return ggProfilePic;
    }

    public void setGgProfilePic(String ggProfilePic) {
        this.ggProfilePic = ggProfilePic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
