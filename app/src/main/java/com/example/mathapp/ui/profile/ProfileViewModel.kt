package com.example.mathapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.data.exam.ProductsRepositoryImpl
import com.example.mathapp.data.model.UserDataModel
import com.example.mathapp.data.room.UserRepoImpl
import com.example.mathapp.data.room.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: UserRepoImpl
): ViewModel() {

    private val _ldata = MutableLiveData<Int>()
    val ldata: LiveData<Int> = _ldata

    private val _readAllData = MutableLiveData<List<UserEntity>>()
    val readAllData : LiveData<List<UserEntity>> = _readAllData

    fun addUser(adduser:UserEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUsers(adduser)
        }
    }

    fun updateUser(updateUser:UserEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUsers(updateUser)
        }
    }

    fun getUser():List<UserEntity>?{
        viewModelScope.launch {
            _readAllData.value= repository.getUsers()
        }
            return readAllData.value
    }
}