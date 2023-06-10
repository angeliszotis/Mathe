package com.example.mathapp.di.exam

import com.example.mathapp.data.exam.QuestionRepositoryImpl
import com.example.mathapp.domain.exam.QuestionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ExamModule {

    @Binds
    fun bindQuestionRepository(questionRepository: QuestionRepositoryImpl): QuestionRepository
}