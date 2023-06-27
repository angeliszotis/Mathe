package com.example.mathapp.usecase.user

import com.example.mathapp.domain.user.UsersRepository
import com.example.mathapp.framework.users.model.UserEntity
import javax.inject.Inject

class InsertUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    suspend fun invoke(user: UserEntity) {
        repository.insertUsers(user)
    }
}