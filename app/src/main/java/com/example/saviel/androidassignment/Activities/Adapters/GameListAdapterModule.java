package com.example.saviel.androidassignment.Activities.Adapters;

import android.content.Context;

import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class GameListAdapterModule {
    private Context context;

    public GameListAdapterModule(Context context) {
        this.context = context;
    }

    @Provides
    public GameListAdapter gameListAdapter() {
        return new GameListAdapter(context);
    }
}
