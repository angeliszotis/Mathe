package com.example.mathapp.ui.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.result.model.ResultEntity
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.usecase.score.external.GetScoreExternalUseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    private val getScoreExternalUseCase: GetScoreExternalUseCase?,
    private val getScoreInternalUseCase: GetScoreInternalUseCase
) : ViewModel() {

    private val _score = MutableLiveData<List<ResultModel>>()
    val score: LiveData<List<ResultModel>> get() = _score

    private val _readAllData = MutableLiveData<List<ResultEntity>>()
    val readAllData: LiveData<List<ResultEntity>> = _readAllData

    init {
        fetchScore()
        getUser()
    }

    private fun fetchScore() {
        viewModelScope.launch {
            try {
                val result = getScoreExternalUseCase?.invoke()
                if (result != null) {
                    _score.value =
                        result.sortedWith(compareByDescending<ResultModel> { it.corect.toInt() }
                            .thenBy { it.time.toInt() })
                }
                //result ?: emptyList()
            } catch (e: Exception) {
                // Handle the exception
                Log.e("ResultViewModel", "Error fetching score: ${e.message}", e)
            }
        }
    }

    private fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getScoreInternalUseCase.invoke().collect { users ->
                _readAllData.postValue(users)
            }
        }
    }
}