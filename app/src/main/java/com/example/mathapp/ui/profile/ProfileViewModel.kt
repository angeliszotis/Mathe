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


    private val _readAllData = MutableLiveData<List<UserEntity>>()
    val readAllData: LiveData<List<UserEntity>> = _readAllData

    fun addUser(adduser: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUsers(adduser)
        }
    }

    fun updateUser(updateUser: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUsers(updateUser)
        }
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getUsersUseCase.invoke().collect { users ->
                _readAllData.postValue(users)
            }
        }
    }
}