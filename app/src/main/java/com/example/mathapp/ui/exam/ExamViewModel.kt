package com.example.mathapp.ui.exam

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.framework.result.model.ResultAnswerModel
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
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit2
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit3
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit4
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit5
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit6
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit7
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit8
import com.example.mathapp.ui.exam.map.userMap
import com.example.mathapp.usecase.exam.unit1.GetQuestionsUnitUseCase
import com.example.mathapp.usecase.result.InsertResultUnit1UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit1UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit2UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit3UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit4UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit5UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit6UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit7UseCase
import com.example.mathapp.usecase.score.internal.GetScoreInternalUnit8UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit1UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit2UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit3UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit4UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit5UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit6UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit7UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUnit8UseCase
import com.example.mathapp.usecase.user.GetLastUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    private val getQuestionsUnitUseCase: GetQuestionsUnitUseCase,
    private var insertScoreInternalUnit1UseCase: InsertScoreInternalUnit1UseCase,
    private val insertScoreInternalUnit2UseCase: InsertScoreInternalUnit2UseCase,
    private val insertScoreInternalUnit3UseCase: InsertScoreInternalUnit3UseCase,
    private val insertScoreInternalUnit4UseCase: InsertScoreInternalUnit4UseCase,
    private val insertScoreInternalUnit5UseCase: InsertScoreInternalUnit5UseCase,
    private val insertScoreInternalUnit6UseCase: InsertScoreInternalUnit6UseCase,
    private val insertScoreInternalUnit7UseCase: InsertScoreInternalUnit7UseCase,
    private val insertScoreInternalUnit8UseCase: InsertScoreInternalUnit8UseCase,
    private val resultExternalUnit1UseCase: InsertResultUnit1UseCase,
    private val userUseCase: GetLastUserUseCase,
    private val getScoreInternalUnit1UseCase: GetScoreInternalUnit1UseCase,
    private val getScoreInternalUnit2UseCase: GetScoreInternalUnit2UseCase,
    private val getScoreInternalUnit3UseCase: GetScoreInternalUnit3UseCase,
    private val getScoreInternalUnit4UseCase: GetScoreInternalUnit4UseCase,
    private val getScoreInternalUnit5UseCase: GetScoreInternalUnit5UseCase,
    private val getScoreInternalUnit6UseCase: GetScoreInternalUnit6UseCase,
    private val getScoreInternalUnit7UseCase: GetScoreInternalUnit7UseCase,
    private val getScoreInternalUnit8UseCase: GetScoreInternalUnit8UseCase
) : ViewModel() {


    private val _toastMessage = mutableStateOf<String?>(null)
    val toastMessage: State<String?> = _toastMessage

    private val _randomQuestionModels = MutableLiveData<List<QuestionModel>>(emptyList())
    val randomQuestionModels: LiveData<List<QuestionModel>> = _randomQuestionModels

    private val _internalScore = MutableLiveData<List<ResultModel>>()
    val internalScore : LiveData<List<ResultModel>> = _internalScore

     fun getRandomQuestions(unit: Int) {
         val questionModels = getQuestionsUnitUseCase.invoke(unit)
        val randomQuestionModels = mutableListOf<QuestionModel>()
        val usedIds = mutableSetOf<Int>()

        while (randomQuestionModels.size < 12 && usedIds.size < questionModels.size) {
            val question = questionModels.random()
            if (question.id !in usedIds && question !in randomQuestionModels) {
                usedIds.add(question.id)
                randomQuestionModels.add(question)
            }
        }
        _randomQuestionModels.value = randomQuestionModels
    }

    fun insertExternalResult(result: ResultAnswerModel, unit: Int) {
        viewModelScope.launch {
            val user = userUseCase.invoke()
            if (user != null && user.name.isNotEmpty()) {
                try {
                    val resultModel = userMap(user, result)
                    resultExternalUnit1UseCase.invoke(resultModel, unit)
                } catch (e: Exception) { Log.e("YODA", "Error inserting external result: ${e.message}") }
            }
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
    fun insertInternalResult(result: ResultAnswerModel, unit: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userUseCase.invoke()
            if (user != null && user.name.isNotEmpty()) {
                try {
                    @Suppress("IMPLICIT_CAST_TO_ANY")
                    val resultModel = when (unit) {
                        1 -> scoreInternalMapUnit(user, result)
                        2 -> scoreInternalMapUnit2(user, result)
                        3 -> scoreInternalMapUnit3(user, result)
                        4 -> scoreInternalMapUnit4(user, result)
                        5 -> scoreInternalMapUnit5(user, result)
                        6 -> scoreInternalMapUnit6(user, result)
                        7 -> scoreInternalMapUnit7(user, result)
                        8 -> scoreInternalMapUnit8(user, result)
                        else -> throw IllegalArgumentException("Invalid unit value: $unit")
                    }
                    when (unit) {
                        1 -> insertScoreInternalUnit1UseCase.invoke(resultModel as ResultUnit1Entity)
                        2 -> insertScoreInternalUnit2UseCase.invoke(resultModel as ResultUnit2Entity)
                        3 -> insertScoreInternalUnit3UseCase.invoke(resultModel as ResultUnit3Entity)
                        4 -> insertScoreInternalUnit4UseCase.invoke(resultModel as ResultUnit4Entity)
                        5 -> insertScoreInternalUnit5UseCase.invoke(resultModel as ResultUnit5Entity)
                        6 -> insertScoreInternalUnit6UseCase.invoke(resultModel as ResultUnit6Entity)
                        7 -> insertScoreInternalUnit7UseCase.invoke(resultModel as ResultUnit7Entity)
                        8 -> insertScoreInternalUnit8UseCase.invoke(resultModel as ResultUnit8Entity)
                        else -> throw IllegalArgumentException("Invalid unit value: $unit")
                    }
                } catch (e: Exception) {
                    Log.e("YODA", "Error inserting internal result: ${e.message}", e)
                }
            }
        }
    }
}


