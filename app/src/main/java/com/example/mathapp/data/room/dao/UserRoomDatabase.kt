package com.example.mathapp.data.room.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mathapp.data.room.entity.UserEntity

@Database(entities = [(UserEntity::class)], version = 1)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun quizDao(): dbDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context): UserRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): UserRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                UserRoomDatabase::class.java,
                "UserRoomDatabase"
            )
                .build()
        }
    }

}