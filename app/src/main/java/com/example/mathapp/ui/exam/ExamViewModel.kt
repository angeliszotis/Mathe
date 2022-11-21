package com.example.mathapp.ui.exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.data.nav_data.NavButtonItems
import com.example.mathapp.util.SingleLiveEvent
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val database: FirebaseDatabase
) : ViewModel() {
    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }


}