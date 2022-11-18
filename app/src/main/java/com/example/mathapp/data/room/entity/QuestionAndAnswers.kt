package com.example.mathapp.data.room.entity

import androidx.room.Embedded
import androidx.room.Relation


class QuestionAndAnswers {
    @Embedded
    var question: QuestionEntity? = null

    @Relation(
        parentColumn = "question_id",
        entityColumn = "question_id"
    )
    var answers: List<AnswersEntity> = ArrayList()
}