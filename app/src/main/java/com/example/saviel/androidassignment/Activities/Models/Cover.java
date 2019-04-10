package com.example.saviel.androidassignment.Activities.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cover {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
