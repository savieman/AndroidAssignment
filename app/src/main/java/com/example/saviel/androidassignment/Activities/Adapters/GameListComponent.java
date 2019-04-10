package com.example.saviel.androidassignment.Activities.Adapters;

import com.example.saviel.androidassignment.Activities.Activities.GamelistActivity;
import com.example.saviel.androidassignment.Activities.Adapters.GameListAdapterModule;
import com.example.saviel.androidassignment.Activities.Root.AppComponent;

import dagger.Component;

@Component(modules = {GameListAdapterModule.class}, dependencies = {AppComponent.class})
public interface GameListComponent {
    void inject(GamelistActivity gamelistActivity);
}
