package com.example.mathapp.ui.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.usecase.score.GetScoreUseCase
import com.example.mathapp.util.NavButtonItems
import com.example.mathapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    private val getScoreUseCase: GetScoreUseCase?
) : ViewModel() {
    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    private val _score = MutableLiveData<List<ResultModel>>()
    val score: LiveData<List<ResultModel>> get() = _score

    init {
        fetchScore()
    }
    fun fetchScore() {
        viewModelScope.launch {
            try {
                val result = getScoreUseCase?.invoke()
                _score.value = result ?: emptyList()
            } catch (e: Exception) {
                // Handle the exception
                Log.e("ResultViewModel", "Error fetching score: ${e.message}", e)
            }
        }
        fun onItemClicked(item: NavButtonItems) {
            _ldata.value = item.destination
        }
    }
}