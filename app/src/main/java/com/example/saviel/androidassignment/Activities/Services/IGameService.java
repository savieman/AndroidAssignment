package com.example.saviel.androidassignment.Activities.Services;

import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IGameService {

    @Headers({
            "user-key: 624f702c19d1149e4bbe1b4df3b0f308",
            "Accept: application/json"
    })
    @GET("games?fields=id,name,summary,cover.url")
    Observable<List<Game>> getGames();

    @Headers({
            "user-key: 624f702c19d1149e4bbe1b4df3b0f308",
            "Accept: application/json"
    })
    @GET("games")
    Call<List<Game>> getGame();
}
