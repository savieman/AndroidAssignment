package com.example.saviel.androidassignment.Activities.DAOS;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;

@Dao
public interface GameDao {

    @Insert
    void addGame(Game game);

    @Query("DELETE FROM game")
    void deleteAll();

    @Query("SELECT * from game ORDER BY name ASC")
    LiveData<List<Game>> getAllGames();
}
