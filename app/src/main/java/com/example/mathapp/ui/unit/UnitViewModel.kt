package com.example.mathapp.ui.unit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UnitViewModel : ViewModel() {

    private val _ldata = MutableLiveData<Int>()
    val ldata: LiveData<Int> = _ldata


}