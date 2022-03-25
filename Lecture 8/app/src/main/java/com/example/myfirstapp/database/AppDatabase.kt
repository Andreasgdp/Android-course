package com.example.myfirstapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user-database")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}