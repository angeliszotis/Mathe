package com.example.mathapp.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mathapp.framework.db.dao.ResultUnit1Dao
import com.example.mathapp.framework.db.dao.ResultUnit2Dao
import com.example.mathapp.framework.db.dao.ResultUnit3Dao
import com.example.mathapp.framework.db.dao.ResultUnit4Dao
import com.example.mathapp.framework.db.dao.ResultUnit5Dao
import com.example.mathapp.framework.db.dao.ResultUnit6Dao
import com.example.mathapp.framework.db.dao.ResultUnit7Dao
import com.example.mathapp.framework.db.dao.ResultUnit8Dao
import com.example.mathapp.framework.db.dao.UserDao
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import com.example.mathapp.framework.users.model.UserEntity

@Database(
    entities = [UserEntity::class, ResultUnit1Entity::class, ResultUnit2Entity::class, ResultUnit3Entity::class, ResultUnit4Entity::class, ResultUnit5Entity::class, ResultUnit6Entity::class, ResultUnit7Entity::class, ResultUnit8Entity::class],
    version = 2,
    exportSchema = false
)
abstract class RoomDb : RoomDatabase() {

    abstract fun quizDao(): UserDao
    abstract fun resultUnit1Dao(): ResultUnit1Dao
    abstract fun resultUnit2Dao(): ResultUnit2Dao
    abstract fun resultUnit3Dao(): ResultUnit3Dao
    abstract fun resultUnit4Dao(): ResultUnit4Dao
    abstract fun resultUnit5Dao(): ResultUnit5Dao
    abstract fun resultUnit6Dao(): ResultUnit6Dao
    abstract fun resultUnit7Dao(): ResultUnit7Dao
    abstract fun resultUnit8Dao(): ResultUnit8Dao

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