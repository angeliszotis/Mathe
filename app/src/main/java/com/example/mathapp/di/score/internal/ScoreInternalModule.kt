package com.example.mathapp.di.score.internal

import com.example.mathapp.data.score.internal.ScoreInternalDataSource
import com.example.mathapp.data.score.internal.ScoreInternalRepositoryImpl
import com.example.mathapp.domain.score.internal.ScoreInternalRepository
import com.example.mathapp.framework.score.internal.ScoreInternalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ScoreInternalModule {
    @Binds
    fun bindScoreInternalDataSource(dataSource: ScoreInternalDataSourceImpl): ScoreInternalDataSource

    @Binds
    fun bindScoretInternalRepository(repository: ScoreInternalRepositoryImpl): ScoreInternalRepository

}