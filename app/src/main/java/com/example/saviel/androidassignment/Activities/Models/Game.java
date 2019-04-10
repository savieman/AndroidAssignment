package com.example.saviel.androidassignment.Activities.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cover")
    @Expose
    private Integer cover;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("summary")
    @Expose
    private String summary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCover() {
        return cover;
    }

    public void setCover(Integer cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Game(String name) {
        this.name = name;
    }
}
