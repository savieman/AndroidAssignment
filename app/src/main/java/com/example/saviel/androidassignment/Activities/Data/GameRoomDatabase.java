package com.example.saviel.androidassignment.Activities.Data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.saviel.androidassignment.Activities.DAOS.GameDao;
import com.example.saviel.androidassignment.Activities.Models.Game;

@Database(entities = {Game.class}, version = 1)
public abstract class GameRoomDatabase extends RoomDatabase{
    private static volatile GameRoomDatabase INSTANCE;

    public static GameRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Game.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GameRoomDatabase.class, "game_database")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract GameDao gameDao();

    private static RoomDatabase.Callback roomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final GameDao gameDao;

        public PopulateDbAsync(GameRoomDatabase instance) {
            gameDao = instance.gameDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            gameDao.deleteAll();
            Game game = new Game(1, "Bloodborne");
            gameDao.addGame(game);
            return null;
        }
    }

}
