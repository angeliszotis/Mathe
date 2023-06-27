package com.example.mathapp.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mathapp.framework.db.dao.resultDao
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.framework.db.dao.userDao
import com.example.mathapp.framework.result.model.ResultEntity

@Database(entities = [UserEntity::class, ResultEntity::class], version = 2)
abstract class RoomDb : RoomDatabase() {

    abstract fun quizDao(): userDao
    abstract fun resultDao(): resultDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDb? = null

        fun getDatabase(context: Context): RoomDb {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): RoomDb {
            return Room.databaseBuilder(
                context.applicationContext,
                RoomDb::class.java,
                "UserRoomDatabase"
            )
                .fallbackToDestructiveMigration() // Add this line to allow destructive migration
                .build()
        }
    }
}