package com.example.gamebacklog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gamebacklog.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class GameRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var reminderRDInstance: GameRoomDatabase? = null

        fun getDatabase(context: Context): GameRoomDatabase? {
            if (reminderRDInstance == null) {
                synchronized(GameRoomDatabase::class.java) {
                    if (reminderRDInstance == null) {
                        reminderRDInstance = Room.databaseBuilder(
                                context.applicationContext,
                                GameRoomDatabase::class.java,
                                DATABASE_NAME
                            )
                            .build()
                    }
                }
            }
            return reminderRDInstance
        }
    }
}