package com.example.mathapp.data.room.entity

import androidx.room.*


@Entity(
    tableName = "answers", foreignKeys = [
        ForeignKey(
            entity = QuestionEntity::class,
            parentColumns = ["question_id"],
            childColumns = ["question_id"],
            onDelete = ForeignKey.CASCADE
        )], indices = [Index("question_id")]
)
data class AnswersEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "answer_id")
    val answerId: Int,
    @ColumnInfo(name = "question_id")
    val questionId: Int,
    @ColumnInfo(name = "is_correct")
    val isCorrect: Boolean,
    @ColumnInfo(name = "answer_text")
    val text: String
)