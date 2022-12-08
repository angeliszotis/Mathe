package com.example.mathapp.domain

import com.example.mathapp.data.model.UserDataModel
import com.example.mathapp.data.room.entity.UserEntity

interface UsersRepo {
    suspend fun addUsers(user: UserEntity)
    suspend fun updateUsers(user:UserEntity)
    suspend fun getUsers():List<UserEntity>
}