package com.example.mathapp.usecase.user

import com.example.mathapp.domain.user.UsersRepository
import com.example.mathapp.framework.users.model.UserEntity
import javax.inject.Inject


class GetLastUserUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    suspend fun invoke(): UserEntity? {
        return repository.getLastUser()
    }
}