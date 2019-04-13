package com.example.saviel.androidassignment.Activities.Adapters;

import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class GameListAdapterModule {
    List<Game> gameList;

    public GameListAdapterModule(List<Game> gameList) {
        this.gameList = gameList;
    }

    @Provides
    public GameListAdapter gameListAdapter() {
//            return new GameListAdapter(gameList);
        return null;
    }
}
