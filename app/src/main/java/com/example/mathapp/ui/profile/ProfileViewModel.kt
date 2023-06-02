package com.example.mathapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.data.room.UserRepositoryInterfaceImpl
import com.example.mathapp.data.room.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepositoryInterfaceImpl
) : ViewModel() {

    private val _ldata = MutableLiveData<Int>()
    val ldata: LiveData<Int> = _ldata

    private val _readAllData = MutableLiveData<List<UserEntity>>()
    val readAllData: LiveData<List<UserEntity>> = _readAllData

    fun addUser(adduser: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUsers(adduser)
        }
    }

    fun updateUser(updateUser: UserEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUsers(updateUser)
        }
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _readAllData.postValue(repository.getUsers())

        }

    }
}