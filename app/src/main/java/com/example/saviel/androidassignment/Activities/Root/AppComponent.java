package com.example.saviel.androidassignment.Activities.Root;

import com.example.saviel.androidassignment.Activities.Services.GameService;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    GameService getGameService();
}
