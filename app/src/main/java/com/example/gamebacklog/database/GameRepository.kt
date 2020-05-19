package com.example.gamebacklog.database

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.gamebacklog.model.Game

class GameRepository(context: Context) {
    //todo remove null calls
    private var gameDao: GameDao?

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database?.gameDao()
    }

    fun getAllGames(): MutableLiveData<List<Game>> {
        return gameDao?.getGames() ?: MutableLiveData(emptyList())
    }

    fun deleteAllGames() {
        return gameDao!!.deleteAllGames()
    }

    suspend fun insertGame(game: Game) {
        gameDao?.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        return gameDao!!.deleteGame(game)
    }
}