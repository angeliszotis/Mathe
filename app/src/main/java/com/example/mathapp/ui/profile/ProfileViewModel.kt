package com.example.mathapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _ldata = MutableLiveData<Int>()
    val ldata: LiveData<Int> = _ldata


}