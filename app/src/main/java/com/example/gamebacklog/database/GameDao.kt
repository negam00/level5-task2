package com.example.gamebacklog.database

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.gamebacklog.model.Game

@Dao
interface GameDao {
    @Insert
    suspend fun insertGame(game: Game)

    @Query("SELECT * FROM Game ORDER BY releaseDate ASC")
    fun getGames(): MutableLiveData<List<Game>>

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM Game")
    fun deleteAllGames()
}