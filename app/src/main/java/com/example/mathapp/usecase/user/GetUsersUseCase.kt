package com.example.mathapp.usecase.user

import com.example.mathapp.domain.user.UsersRepository
import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    suspend fun invoke(): Flow<List<UserEntity>> {
        return repository.getUsers()
    }
}