package com.example.mathapp.data.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "questions", indices = [Index("question_id")])
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "question_id")
    var questionId: Int,
    val text: String,
    val difficulty: String = "easy",
    val category: String = "android"
)