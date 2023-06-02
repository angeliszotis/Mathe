package com.example.mathapp.domain.user

import com.example.mathapp.data.room.entity.UserEntity

interface UsersRepositoryInterface {
    suspend fun addUsers(user: UserEntity)
    suspend fun updateUsers(user: UserEntity)
    suspend fun getUsers(): List<UserEntity>
}