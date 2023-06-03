package com.example.mathapp.data.users

import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserDataSource {
    suspend fun insertUsers(user: UserEntity)
    suspend fun updateUsers(user: UserEntity)
    suspend fun getUsers(): Flow<List<UserEntity>>
}