package com.example.mathapp.di.users

import com.example.mathapp.data.users.UserDataSource
import com.example.mathapp.data.users.UserRepositoryImpl
import com.example.mathapp.domain.user.UsersRepository
import com.example.mathapp.framework.users.UserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UsersModule {

    @Binds
    fun bindUsersDataSource(dataSource: UserDataSourceImpl): UserDataSource

    @Binds
    fun bindUsersRepository(repository: UserRepositoryImpl): UsersRepository
}
