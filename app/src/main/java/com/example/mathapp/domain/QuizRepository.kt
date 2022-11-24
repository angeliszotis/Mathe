package com.example.mathapp.domain

import com.example.mathapp.data.model.QuestionsModel
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    fun getQuizOnce(): Flow<Resource<List<QuestionsModel>>>
    fun getQuizRealtime(): Flow<Resource<List<QuestionsModel>>>
}