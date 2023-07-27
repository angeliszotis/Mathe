package com.example.mathapp.ui.score.achievement

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
class AchievementViewModel @Inject constructor(
    private val getScoreInternalUnit1UseCase: GetScoreInternalUnit1UseCase,
    private val getScoreInternalUnit2UseCase: GetScoreInternalUnit2UseCase,
    private val getScoreInternalUnit3UseCase: GetScoreInternalUnit3UseCase,
    private val getScoreInternalUnit4UseCase: GetScoreInternalUnit4UseCase,
    private val getScoreInternalUnit5UseCase: GetScoreInternalUnit5UseCase,
    private val getScoreInternalUnit6UseCase: GetScoreInternalUnit6UseCase,
    private val getScoreInternalUnit7UseCase: GetScoreInternalUnit7UseCase,
    private val getScoreInternalUnit8UseCase: GetScoreInternalUnit8UseCase
) : ViewModel() {

    private val _internalScore = MutableLiveData<List<ResultModel>>()
    val internalScore: LiveData<List<ResultModel>> = _internalScore
    private val _internalScore2 = MutableLiveData<List<ResultModel>>()
    val internalScore2: LiveData<List<ResultModel>> = _internalScore2
    private val _internalScore3 = MutableLiveData<List<ResultModel>>()
    val internalScore3: LiveData<List<ResultModel>> = _internalScore3
    private val _internalScore4 = MutableLiveData<List<ResultModel>>()
    val internalScore4: LiveData<List<ResultModel>> = _internalScore4
    private val _internalScore5 = MutableLiveData<List<ResultModel>>()
    val internalScore5: LiveData<List<ResultModel>> = _internalScore5
    private val _internalScore6 = MutableLiveData<List<ResultModel>>()
    val internalScore6: LiveData<List<ResultModel>> = _internalScore6
    private val _internalScore7 = MutableLiveData<List<ResultModel>>()
    val internalScore7: LiveData<List<ResultModel>> = _internalScore7
    private val _internalScore8 = MutableLiveData<List<ResultModel>>()
    val internalScore8: LiveData<List<ResultModel>> = _internalScore8

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
                when(unit){
                    1 -> _internalScore.postValue(resultModelList)
                    2 -> _internalScore2.postValue(resultModelList)
                    3 -> _internalScore3.postValue(resultModelList)
                    4 -> _internalScore4.postValue(resultModelList)
                    5 -> _internalScore5.postValue(resultModelList)
                    6 -> _internalScore6.postValue(resultModelList)
                    7 -> _internalScore7.postValue(resultModelList)
                    8 -> _internalScore8.postValue(resultModelList)
                    else -> throw IllegalArgumentException("Invalid unit value: $unit")
                }

            }
        }
    }
}