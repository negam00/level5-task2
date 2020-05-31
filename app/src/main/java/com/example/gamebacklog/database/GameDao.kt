package com.example.gamebacklog.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gamebacklog.model.Game

@Dao
interface GameDao {
    @Insert
    suspend fun addGame(game: Game)

    @Query("SELECT * FROM Game ORDER BY releaseDate ASC")
    fun getGames(): LiveData<List<Game>>

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("DELETE FROM Game")
    fun deleteAllGames()
}