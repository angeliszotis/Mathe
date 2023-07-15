package com.example.mathapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.data.users.UserRepositoryImpl
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.usecase.user.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {


    private val _getUserData = MutableLiveData<List<UserEntity>>()
    val getUserData: LiveData<List<UserEntity>> = _getUserData

    init {
        getUser()
    }
    fun addUser(name: String, surname: String, school: String) {
        val userEntity = UserEntity(name =name, surname = surname, school =  school)
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUsers(userEntity)
        }
    }
/*
    fun setUDM(viewModel: ProfileViewModel, name: String, surname: String, school: String): UserEntity {
        val userEntity = UserEntity(name =name, surname = surname, school =  school)
        viewModel.addUser(userEntity)
        return userEntity
    }

 */
    fun updateUser(updateUser: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUsers(updateUser)
        }
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getUsersUseCase.invoke().collect { users ->
                _getUserData.postValue(users)
            }
        }
    }
}