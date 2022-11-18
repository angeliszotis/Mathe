package com.example.mathapp.data.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.android.cassianasoares.data.db.migrations.Migration1To2
import com.demo.android.cassianasoares.data.db.migrations.Migration1To4
import com.demo.android.cassianasoares.data.db.migrations.Migration2To3
import com.demo.android.cassianasoares.data.db.migrations.Migration3To4
import com.example.mathapp.data.room.entity.AnswersEntity
import com.example.mathapp.data.room.entity.QuestionEntity

@Database(entities = [(QuestionEntity::class), (AnswersEntity::class)], version = 4)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun quizDao(): dbDao

    companion object {
        val MIGRATION_1_TO_2 = Migration1To2()
        val MIGRATION_2_TO_3 = Migration2To3()
        val MIGRATION_3_TO_4 = Migration3To4()
        val MIGRATION_1_TO_4 = Migration1To4()
    }

}