package com.example.mathapp.usecase.user

import com.example.mathapp.domain.user.UsersRepositoryInterface
import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UsersRepositoryInterface
) {
    suspend fun invoke(): Flow<List<UserEntity>> {
        return repository.getUsers()
    }
}