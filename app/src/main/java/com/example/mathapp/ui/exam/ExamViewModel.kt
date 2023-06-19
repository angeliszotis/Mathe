package com.example.mathapp.ui.exam

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.framework.result.model.ResultAnswerModel
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.usecase.exam.GetQuestionsUseCase
import com.example.mathapp.usecase.result.InsertResultUseCase
import com.example.mathapp.usecase.user.GetLastUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
    getQuestionsUseCase: GetQuestionsUseCase,
    private val resultUseCase: InsertResultUseCase,
    private val userUseCase: GetLastUserUseCase
) : ViewModel() {

    private val questions = getQuestionsUseCase.invoke()
    val randomQuestions = getRandomQuestions(questions)

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


    //  private val _insertResultStatus = MutableStateFlow<Result<Unit>>(Idle)
    // val insertResultStatus: StateFlow<Result<Unit>> = _insertResultStatus.asStateFlow()

    fun insertResult(result: ResultAnswerModel) {
        viewModelScope.launch {
            val user = userUseCase.invoke()
            try {
                user?.let { userMap(it,result) }?.let { resultUseCase.invoke(it) }
            } catch (e: Exception) {
                Log.e("YODA", e.toString())
            }
        }
    }

    private fun userMap(userEntity: UserEntity,result: ResultAnswerModel): ResultModel {
        return ResultModel(
            name = userEntity.name,
            surname = userEntity.surname,
            school = userEntity.school,
             correct = result.corect.toString() ,
             incorrect = result.incorect.toString(),
             time = result.time.toString()
        )
    }
}