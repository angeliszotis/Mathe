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
        db.quizDao().insertData(user)
    }

    override suspend fun updateUsers(user: UserEntity) {
        db.quizDao().updateData(user)
    }

    override suspend fun getUsers(): Flow<List<UserEntity>> {
        return db.quizDao().getData()
    }

    override suspend fun getLastUser(): UserEntity? {
        return db.quizDao().getLastUser()
    }
}
