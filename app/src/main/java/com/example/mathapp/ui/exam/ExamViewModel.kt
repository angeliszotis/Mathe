package com.example.mathapp.ui.exam

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.framework.result.model.ResultAnswerModel
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit2
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit3
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit4
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit5
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit6
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit7
import com.example.mathapp.ui.exam.map.scoreInternalMapUnit8
import com.example.mathapp.ui.exam.map.userMap
import com.example.mathapp.usecase.exam.unit1.GetQuestionsUnit1UseCase
import com.example.mathapp.usecase.exam.unit1.GetQuestionsUnit2UseCase
import com.example.mathapp.usecase.result.InsertResultUnit1UseCase
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
    getQuestionsUnit1UseCase: GetQuestionsUnit1UseCase,
    getQuestionsUnit2UseCase: GetQuestionsUnit2UseCase,
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
) : ViewModel() {

    private val questions = getQuestionsUnit1UseCase.invoke()
    val randomQuestions = getRandomQuestions(questions)

    private val questions2 = getQuestionsUnit2UseCase.invoke()
    val randomQuestions2 = getRandomQuestions(questions2)

    private val _toastMessage = mutableStateOf<String?>(null)
    val toastMessage: State<String?> = _toastMessage

    private fun getRandomQuestions(questionModels: List<QuestionModel>): List<QuestionModel> {
        val randomQuestionModels = mutableListOf<QuestionModel>()
        val usedIds = mutableSetOf<Int>()
        while (randomQuestionModels.size < 12 && usedIds.size < questionModels.size) {
            val question = questionModels.random()
            if (question.id !in usedIds && question !in randomQuestionModels) {
                usedIds.add(question.id)
                randomQuestionModels.add(question)
            }
        }
        return randomQuestionModels
    }

    fun insertExternalResult(result: ResultAnswerModel, unit: Int) {
        viewModelScope.launch {
            val user = userUseCase.invoke()
            if (user != null && user.name.isNotEmpty()) {
                try {
                    val resultModel = userMap(user, result)
                    resultExternalUnit1UseCase.invoke(resultModel, unit)
                } catch (e: Exception) {
                    Log.e("YODA", "Error inserting external result: ${e.message}")
                }
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
                } catch (e: Exception) { Log.e("YODA", "Error inserting internal result: ${e.message}", e) }
            }
        }
    }


}


