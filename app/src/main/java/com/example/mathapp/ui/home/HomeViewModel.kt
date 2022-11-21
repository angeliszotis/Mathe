package com.example.mathapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.data.nav_data.NavButtonItems
import com.example.mathapp.util.SingleLiveEvent

class HomeViewModel : ViewModel() {
    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }


}