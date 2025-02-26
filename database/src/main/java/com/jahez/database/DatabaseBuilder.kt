package com.jahez.database

import android.content.Context
import androidx.room.Room

// helper to build database
internal object DatabaseBuilder {
    private const val DATABASE_NAME = "com.jahez.app.database"
    private val LOCK = Any()

    fun getInstance(context: Context): JahezDatabase {
        return synchronized(LOCK) {
            Room.databaseBuilder(
                context.applicationContext,
                JahezDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }
}