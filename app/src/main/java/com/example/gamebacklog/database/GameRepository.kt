package com.example.gamebacklog.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gamebacklog.model.Game

class GameRepository(context: Context) {
    //todo remove null calls
    private var gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getAllGames(): LiveData<List<Game>> {
        return gameDao.getGames()
    }

    fun deleteAllGames() = gameDao.deleteAllGames()

    suspend fun addGame(game: Game) = gameDao.addGame(game)

    suspend fun deleteGame(game: Game) = gameDao.deleteGame(game)
}