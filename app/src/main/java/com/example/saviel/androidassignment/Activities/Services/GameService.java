package com.example.saviel.androidassignment.Activities.Services;

import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.Activities.Retrofit.RetrofitClient;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class GameService {
    Retrofit retrofit;

    public GameService(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    public Observable<List<Game>> getGames(){
        IGameService gameService = retrofit.create(IGameService.class);
        Observable<List<Game>> observableRepo = gameService.getGames();

        return observableRepo;
    }
}
