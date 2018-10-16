package com.example.hiennv.mvparchitecture.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repo {
    @Expose
    @SerializedName("project_url")
    private String projectUrl;

    @Expose
    @SerializedName("img_url")
    private String imgUrl;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("description")
    private String description;

    public Repo(String projectUrl, String imgUrl, String title, String description) {
        this.projectUrl = projectUrl;
        this.imgUrl = imgUrl;
        this.title = title;
        this.description = description;
    }

    public Repo() {
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Repo))
            return false;
        Repo repo = (Repo) obj;
        if (!projectUrl.equals(repo.projectUrl))
            return false;
        if (!imgUrl.equals(repo.imgUrl))
            return false;
        if (title.equals(repo.title))
            return false;
        return (description.equals(repo.description));
    }

    @Override
    public int hashCode() {
        int result = projectUrl != null ? projectUrl.hashCode() : 0;
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
