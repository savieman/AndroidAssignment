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
    private final static String t_cover_big = "t_cover_big";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String url) {
        this.thumbUrl = thumbUrl;
    }

    public String getCoverUrl(){
        return thumbUrl.substring(0, 36) + t_cover_big + thumbUrl.substring(43);
    }
}
