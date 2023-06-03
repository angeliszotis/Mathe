package com.example.mathapp.framework.users

import com.example.mathapp.data.users.UserDataSource
import com.example.mathapp.framework.db.RoomDb
import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
private val db: RoomDb
) : UserDataSource {
    override suspend fun insertUsers(user: UserEntity) {
        db.quizDao().insertAll(user)
    }

    override suspend fun updateUsers(user: UserEntity) {
        db.quizDao().updateUsers(user)
    }

    override suspend fun getUsers(): Flow<List<UserEntity>> {
        return db.quizDao().getAll()
    }
}
