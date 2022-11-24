package com.example.mathapp.domain.Quiz

import com.example.mathapp.data.room.entity.QuestionAndAnswers

sealed class QuizState {

    object LoadingState : QuizState()
    data class DataState(val data: QuestionAndAnswers) : QuizState()
    object EmptyState : QuizState()
    data class FinishState(val numberOfQuestions: Int, val score: Int) : QuizState()

}