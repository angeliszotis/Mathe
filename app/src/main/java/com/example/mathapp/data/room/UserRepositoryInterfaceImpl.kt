package com.example.mathapp.data.room

import com.example.mathapp.data.room.dao.UserRoomDatabase
import com.example.mathapp.data.room.entity.UserEntity
import com.example.mathapp.domain.user.UsersRepositoryInterface
import javax.inject.Inject

class UserRepositoryInterfaceImpl @Inject constructor(
    private val db: UserRoomDatabase
) : UsersRepositoryInterface {
    override suspend fun addUsers(user: UserEntity) {
        db.quizDao().insertAll(user)
    }

    override suspend fun updateUsers(user: UserEntity) {
        db.quizDao().updateUsers(user)
    }

    override suspend fun getUsers(): List<UserEntity> {
        return db.quizDao().getAll()

    }
}

