package com.example.mathapp.ui.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import com.example.mathapp.ui.exam.map.mapToResultModelUnit
import com.example.mathapp.usecase.score.external.GetScoreExternalUseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit1UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit2UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit3UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit4UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit5UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit6UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit7UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit8UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreViewModel @Inject constructor(
    private val getScoreExternalUseCase: GetScoreExternalUseCase?,
    private val getScoreInternalUnit1UseCase: GetScoreInternalUnit1UseCase,
    private val getScoreInternalUnit2UseCase: GetScoreInternalUnit2UseCase,
    private val getScoreInternalUnit3UseCase: GetScoreInternalUnit3UseCase,
    private val getScoreInternalUnit4UseCase: GetScoreInternalUnit4UseCase,
    private val getScoreInternalUnit5UseCase: GetScoreInternalUnit5UseCase,
    private val getScoreInternalUnit6UseCase: GetScoreInternalUnit6UseCase,
    private val getScoreInternalUnit7UseCase: GetScoreInternalUnit7UseCase,
    private val getScoreInternalUnit8UseCase: GetScoreInternalUnit8UseCase
) : ViewModel() {

    private val _externalScore = MutableLiveData<List<ResultModel>>()
    val externalScore : LiveData<List<ResultModel>> get() = _externalScore

    private val _internalScore = MutableLiveData<List<ResultModel>>()
    val internalScore : LiveData<List<ResultModel>> = _internalScore


     fun getScoreExternal(unit: Int) {
        viewModelScope.launch {
            try {
                val result = getScoreExternalUseCase?.invoke(unit = unit)
                if (result != null) {
                    _externalScore.value = result.sortedWith(compareByDescending<ResultModel> { it.correct.toInt() }.thenBy { it.time.toInt() }.thenByDescending { it.point.toInt() })
                }
            } catch (e: Exception) { Log.e("Fire_External_Score", "Error fetching score: ${e.message}", e) }
        }
    }

     fun getScoreInternal(unit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val internalScoreFlow = when (unit) {
                1 -> getScoreInternalUnit1UseCase.invoke()
                2 -> getScoreInternalUnit2UseCase.invoke()
                3 -> getScoreInternalUnit3UseCase.invoke()
                4 -> getScoreInternalUnit4UseCase.invoke()
                5 -> getScoreInternalUnit5UseCase.invoke()
                6 -> getScoreInternalUnit6UseCase.invoke()
                7 -> getScoreInternalUnit7UseCase.invoke()
                8 -> getScoreInternalUnit8UseCase.invoke()
                else -> throw IllegalArgumentException("Invalid unit value: $unit")
            }

            internalScoreFlow.collect { item ->
                val resultModelList = item.map { resultEntity ->
                     when (unit) {
                        1 -> mapToResultModelUnit(resultEntity as ResultUnit1Entity)
                        2 -> mapToResultModelUnit(resultEntity as ResultUnit2Entity)
                        3 -> mapToResultModelUnit(resultEntity as ResultUnit3Entity)
                        4 -> mapToResultModelUnit(resultEntity as ResultUnit4Entity)
                        5 -> mapToResultModelUnit(resultEntity as ResultUnit5Entity)
                        6 -> mapToResultModelUnit(resultEntity as ResultUnit6Entity)
                        7 -> mapToResultModelUnit(resultEntity as ResultUnit7Entity)
                        8 -> mapToResultModelUnit(resultEntity as ResultUnit8Entity)
                        else -> throw IllegalArgumentException("Invalid unit value: $unit")
                    }
                }
                _internalScore.postValue(resultModelList)
            }
        }
    }
}