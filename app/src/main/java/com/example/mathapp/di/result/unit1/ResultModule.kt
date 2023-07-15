package com.example.mathapp.di.result.unit1

import com.example.mathapp.data.result.ResultDataSource
import com.example.mathapp.data.result.ResultRepositoryImpl
import com.example.mathapp.domain.result.ResultRepository
import com.example.mathapp.framework.result.ResultDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface ResultModule {

    @Binds
    fun bindResultDataSource(dataSource: ResultDataSourceImpl): ResultDataSource

    @Binds
    fun bindResultRepository(repository: ResultRepositoryImpl): ResultRepository
}
