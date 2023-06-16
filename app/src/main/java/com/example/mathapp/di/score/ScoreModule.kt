package com.example.mathapp.di.score

import com.example.mathapp.data.score.ScoreDataSource
import com.example.mathapp.data.score.ScoreRepositoryImpl
import com.example.mathapp.domain.score.ScoreRepository
import com.example.mathapp.framework.score.ScoreDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface ScoreModule {

    @Binds
    fun bindScoreDataSource(dataSource: ScoreDataSourceImpl): ScoreDataSource

    @Binds
    fun bindScoretRepository(repository: ScoreRepositoryImpl): ScoreRepository
}