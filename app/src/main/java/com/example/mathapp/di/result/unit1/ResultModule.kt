package com.example.mathapp.di.result.unit1

import com.example.mathapp.data.result.unit1.ResultUnit1DataSource
import com.example.mathapp.data.result.unit1.ResultUnit1RepositoryImpl
import com.example.mathapp.domain.result.unit1.ResultUnit1Repository
import com.example.mathapp.framework.result.unit1.ResultUnit1DataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface ResultModule {

    @Binds
    fun bindResultDataSource(dataSource: ResultUnit1DataSourceImpl): ResultUnit1DataSource

    @Binds
    fun bindResultRepository(repository: ResultUnit1RepositoryImpl): ResultUnit1Repository
}
