package com.example.mathapp.data.users

import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.domain.user.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UsersRepository {
    override suspend fun insertUsers(user: UserEntity) {
        userDataSource.insertUsers(user)
    }

    override suspend fun updateUsers(user: UserEntity) {
        userDataSource.updateUsers(user)
    }

    override suspend fun getUsers(): Flow<List<UserEntity>> {
        return userDataSource.getUsers()
    }
}

