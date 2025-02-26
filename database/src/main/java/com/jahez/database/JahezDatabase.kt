package com.jahez.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class JahezDatabase : RoomDatabase() {
//    abstract fun userDao(): UserDao


    companion object {
        @Volatile
        private var INSTANCE: JahezDatabase? = null

        fun getDatabase(context: Context): JahezDatabase {
            return INSTANCE ?: run {
                val instance = DatabaseBuilder.getInstance(context)
                INSTANCE = instance
                instance
            }
        }
    }
}