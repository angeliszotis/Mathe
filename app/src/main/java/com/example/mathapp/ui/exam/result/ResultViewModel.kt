package com.example.mathapp.ui.exam.result

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.framework.result.model.ResultAnswerModel
import com.example.mathapp.framework.result.model.ResultEntity
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.usecase.exam.unit1.GetQuestionsUnit1UseCase
import com.example.mathapp.usecase.result.unit1.InsertResultUnit1UseCase
import com.example.mathapp.usecase.score.internal.InsertScoreInternalUseCase
import com.example.mathapp.usecase.user.GetLastUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    getQuestionsUnit1UseCase: GetQuestionsUnit1UseCase,
    private val resultExternalUseCase: InsertResultUnit1UseCase,
    private val userUseCase: GetLastUserUseCase,
    private var resultInternalUseCase: InsertScoreInternalUseCase
) : ViewModel() {

    private val questions = getQuestionsUnit1UseCase.invoke()
    val randomQuestions = getRandomQuestions(questions)

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

    fun insertExternalResult(result: ResultAnswerModel) {
        viewModelScope.launch {
            val user = userUseCase.invoke()
            if (user != null) {
                if (user.name.isNotEmpty()) {
                    try {
                        userMap(user, result).let { resultExternalUseCase.invoke(it) }
                    } catch (e: Exception) {
                        Log.e("YODA", e.toString())
                    }
                }
            }
        }
    }

    fun insertInternalResult(result: ResultAnswerModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userUseCase.invoke()
            if (user != null) {
                if (user.name.isNotEmpty()) {
                    try {
                        userInternalMap(user, result).let {
                            resultInternalUseCase.invoke(it)
                            _toastMessage.value = "ολα γοοντ"
                        }
                    } catch (e: Exception) {
                        _toastMessage.value = "οχι γοοντ"
                    }
                }
            }
        }
    }

    private fun userMap(userEntity: UserEntity, result: ResultAnswerModel): ResultModel {
        return ResultModel(
            name = userEntity.name,
            surname = userEntity.surname,
            school = userEntity.school,
            corect = result.corect.toString(),
            incorect = result.incorect.toString(),
            time = result.time.toString()
        )
    }

    private fun userInternalMap(userEntity: UserEntity, result: ResultAnswerModel): ResultEntity {
        return ResultEntity(
            name = userEntity.name,
            surname = userEntity.surname,
            school = userEntity.school,
            correct = result.corect.toString(),
            incorrect = result.incorect.toString(),
            time = result.time.toString()
        )
    }
}

