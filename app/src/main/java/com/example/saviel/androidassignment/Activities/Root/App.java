package com.example.saviel.androidassignment.Activities.Root;

import android.app.Application;

import com.example.saviel.androidassignment.Activities.Services.GameService;

import javax.inject.Singleton;


public class App extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    @Singleton
    public GameService getGameService() {
        return appComponent.getGameService();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
