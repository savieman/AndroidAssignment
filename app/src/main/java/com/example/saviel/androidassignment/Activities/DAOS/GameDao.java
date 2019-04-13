package com.example.saviel.androidassignment.Activities.DAOS;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.saviel.androidassignment.Activities.Models.Game;

import java.util.List;

@Dao
public interface GameDao {

    @Insert
    void addGame(Game game);

    @Query("SELECT * FROM game ORDER BY name ASC")
    LiveData<List<Game>> getAllGames();

    @Update
    void updateGame(Game game);

    @Query("SELECT * FROM game WHERE id = :id")
    Game getGame(Integer id);
}
