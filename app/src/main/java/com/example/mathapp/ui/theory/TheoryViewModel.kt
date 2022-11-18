package com.example.mathapp.ui.theory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TheoryViewModel : ViewModel() {

    private val _ldata = MutableLiveData<Int>()
    val ldata: LiveData<Int> = _ldata


}