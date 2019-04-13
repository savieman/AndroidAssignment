package com.example.saviel.androidassignment.Activities.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.saviel.androidassignment.Activities.DAOS.GameDao;
import com.example.saviel.androidassignment.Activities.Data.GameRoomDatabase;
import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;

public class GameRepository {

    private GameDao gameDao;
    private LiveData<List<Game>> allGames;

    public GameRepository(Application application) {
        GameRoomDatabase db = GameRoomDatabase.getDatabase(application);
        gameDao = db.gameDao();
        allGames = gameDao.getAllGames();
    }

    public LiveData<List<Game>> getAllGames() {
        return allGames;
    }
    
    public void insert (Game game) {
        new insertAsynchTask(gameDao).execute(game);
    }

    public void deleteAll() {
        new deleteAsynchTask(gameDao).execute();
    }

    private static class insertAsynchTask extends AsyncTask<Game, Void, Void>{

        private GameDao asyncTaskDao;

        insertAsynchTask(GameDao gameDao) {
            asyncTaskDao = gameDao;
        }


        @Override
        protected Void doInBackground(final Game... games) {
            asyncTaskDao.addGame(games[0]);
            return null;
        }
    }

    private static class deleteAsynchTask extends AsyncTask<Void, Void, Void>{

        private GameDao asyncTaskDao;

        public deleteAsynchTask(GameDao gameDao) {
            asyncTaskDao = gameDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            asyncTaskDao.deleteAll();
            return null;
        }
    }
}
