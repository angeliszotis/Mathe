package com.example.mathapp.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.framework.db.dao.dbDao

@Database(entities = [(UserEntity::class)], version = 1)
abstract class RoomDb : RoomDatabase() {

    abstract fun quizDao(): dbDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getDatabase(context: Context): RoomDb {
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

        private fun buildDatabase(context: Context): RoomDb {
            return Room.databaseBuilder(
                context.applicationContext,
                RoomDb::class.java,
                "UserRoomDatabase"
            )
                .build()
        }
    }

}