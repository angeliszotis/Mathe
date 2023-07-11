package com.example.mathapp.di.exam.unit1

import com.example.mathapp.data.exam.unit1.QuestionUnit1RepositoryImpl
import com.example.mathapp.domain.exam.unit1.QuestionUnit1Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ExamModule {

    @Binds
    fun bindQuestionRepository(questionRepository: QuestionUnit1RepositoryImpl): QuestionUnit1Repository
}