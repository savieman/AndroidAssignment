package com.example.saviel.androidassignment.Activities.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cover {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String thumbUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }
}
