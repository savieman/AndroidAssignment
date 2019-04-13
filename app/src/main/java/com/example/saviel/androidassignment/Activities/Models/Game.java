package com.example.saviel.androidassignment.Activities.Models;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



@Entity(tableName = "game")
public class Game {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cover")
    @Expose
    @Ignore
    private Cover cover;
    private String thumbUrl;
    @NonNull
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("summary")
    @Expose
    private String summary;

    private final static String t_cover_big = "t_cover_big";



    public Game(@NonNull Integer id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean hasCover() {
        return thumbUrl != null;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.thumbUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getCoverBigUrl(){
        return thumbUrl.substring(0, 36) + t_cover_big + thumbUrl.substring(43);
    }
}