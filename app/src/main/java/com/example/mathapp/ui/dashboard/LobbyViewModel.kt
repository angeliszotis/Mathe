package com.example.mathapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.util.NavButtonItems
import com.example.mathapp.util.SingleLiveEvent

class LobbyViewModel : ViewModel() {
    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }
}