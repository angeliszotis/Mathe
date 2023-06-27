package com.example.mathapp.domain.user

import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun insertUsers(user: UserEntity)
    suspend fun updateUsers(user: UserEntity)
    suspend fun getUsers(): Flow<List<UserEntity>>
    suspend fun getLastUser(): UserEntity?
}