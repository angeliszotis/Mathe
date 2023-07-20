package com.example.mathapp.framework.exam.model
/*
data class QuestionModel(
    val id: Int,
    val text: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)

 */
data class Answer(val text: String, val isCorrect: Boolean)

data class QuestionModel(
    val id: Int,
    val text: String,
    val answers: List<Answer>,
)