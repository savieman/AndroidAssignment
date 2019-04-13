package com.example.saviel.androidassignment.Activities.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.saviel.androidassignment.Activities.Models.Game;
import com.example.saviel.androidassignment.Activities.Repositories.GameRepository;

import java.util.List;

public class GameViewModel extends AndroidViewModel {

    private GameRepository gameRepository;
    private LiveData<List<Game>> allGames;

    public GameViewModel(@NonNull Application application) {
        super(application);
        gameRepository = new GameRepository(application);
        allGames = gameRepository.getAllGames();
    }

    public LiveData<List<Game>> getAllGames() {
        return allGames;
    }

    public void insert(Game game) {
        gameRepository.insert(game);
    }

    public void update(Game game) {
        gameRepository.update(game);
    }

    public Game getGame(Integer id) {
        return gameRepository.getGame(id);
    }
}
