package com.example.saviel.androidassignment.Activities.Repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.saviel.androidassignment.Activities.DAOS.GameDao;
import com.example.saviel.androidassignment.Activities.Data.GameRoomDatabase;
import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;
import java.util.concurrent.ExecutionException;

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

    public void update(Game game) {
        new updateAsynchTask(gameDao).execute(game);
    }

    public Game getGame(Integer id) {
        try {
            return new getGameAsynchTask(gameDao).execute(id).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
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

    private static class updateAsynchTask extends AsyncTask<Game, Void, Void> {

        private GameDao asynchTaskDao;

        public updateAsynchTask(GameDao gameDao) {
            asynchTaskDao = gameDao;
        }

        @Override
        protected Void doInBackground(Game... games) {
            asynchTaskDao.updateGame(games[0]);
            return null;
        }
    }

    private static class getGameAsynchTask extends AsyncTask<Integer, Void, Game>{

        private GameDao asyncTaskDao;

        getGameAsynchTask(GameDao gameDao) {
            asyncTaskDao = gameDao;
        }

        @Override
        protected Game doInBackground(Integer... integers) {
            return asyncTaskDao.getGame(integers[0]);

        }
    }
}
