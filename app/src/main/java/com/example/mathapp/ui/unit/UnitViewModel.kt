package com.example.mathapp.ui.unit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.util.NavExamItems

class UnitViewModel : ViewModel() {

    private val _ldata = MutableLiveData<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    fun onItemClicked(item: NavExamItems) {
        _ldata.value = item.destination
    }
}