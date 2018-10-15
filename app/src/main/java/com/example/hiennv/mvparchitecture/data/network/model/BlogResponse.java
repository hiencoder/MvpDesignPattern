package com.example.hiennv.mvparchitecture.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogResponse {
    @Expose
    @SerializedName("status_code")
    private String statusCode;


    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private List<Blog> data;

    public BlogResponse(String statusCode, String message, List<Blog> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public BlogResponse() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Blog> getData() {
        return data;
    }

    public void setData(List<Blog> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof BlogResponse))
            return false;
        BlogResponse blogResponse = (BlogResponse) obj;
        if (!statusCode.equals(blogResponse.statusCode))
            return false;
        if (!message.equals(blogResponse.message))
            return false;

        return data.equals(blogResponse.data);
    }

    @Override
    public int hashCode() {
        int result = statusCode.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + data.hashCode();
        return result;
    }
}
