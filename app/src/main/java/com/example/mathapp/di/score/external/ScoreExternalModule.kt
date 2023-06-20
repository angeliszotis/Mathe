package com.example.mathapp.di.score.external

import com.example.mathapp.data.score.external.ScoreExternalDataSource
import com.example.mathapp.data.score.external.ScoreExternalRepositoryImpl
import com.example.mathapp.domain.score.external.ScoreExternalRepository
import com.example.mathapp.framework.score.external.ScoreExternalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface ScoreExternalModule {

    @Binds
    fun bindScoreExternalDataSource(dataSource: ScoreExternalDataSourceImpl): ScoreExternalDataSource

    @Binds
    fun bindScoretExternalRepository(repository: ScoreExternalRepositoryImpl): ScoreExternalRepository
}