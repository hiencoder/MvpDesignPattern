package com.example.hiennv.mvparchitecture.data.network.model;

import com.example.hiennv.mvparchitecture.BuildConfig;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenSoureResponse {
    @Expose
    @SerializedName("status_code")
    private String statusCode;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private List<Repo> data;

    public OpenSoureResponse(String statusCode, String message, List<Repo> data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public OpenSoureResponse() {
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

    public List<Repo> getData() {
        return data;
    }

    public void setData(List<Repo> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof OpenSoureResponse))
            return false;
        OpenSoureResponse openSoureResponse = (OpenSoureResponse) obj;
        if (!statusCode.equals(openSoureResponse.statusCode))
            return false;
        if (!message.equals(openSoureResponse.message))
            return false;
        return data != null ? data.equals(openSoureResponse.data) : openSoureResponse.data == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode != null ? statusCode.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }


}
