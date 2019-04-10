package com.example.saviel.androidassignment.Activities.Root;

import com.example.saviel.androidassignment.Activities.Retrofit.RetrofitClient;
import com.example.saviel.androidassignment.Activities.Services.GameService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {
    @Provides
    Retrofit provideRetrofit(){
        return RetrofitClient.provideRetrofit();
    }

    @Provides
    GameService provideGameService(Retrofit retrofit){
        return new GameService(retrofit);

    }
}
