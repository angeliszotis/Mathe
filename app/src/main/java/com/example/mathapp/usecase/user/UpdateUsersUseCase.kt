package com.example.mathapp.usecase.user

import com.example.mathapp.domain.user.UsersRepositoryInterface
import com.example.mathapp.framework.users.model.UserEntity
import javax.inject.Inject

class UpdateUsersUseCase @Inject constructor(
    private val repository: UsersRepositoryInterface
) {
    suspend fun invoke(user: UserEntity){
        repository.updateUsers(user)
    }
}