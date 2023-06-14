package com.example.mathapp.ui.exam

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.usecase.exam.GetQuestionsUseCase
import com.example.mathapp.usecase.result.InsertResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
      getQuestionsUseCase: GetQuestionsUseCase,
      private val resultUseCase: InsertResultUseCase
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

    fun insertResult(result: ResultModel) {
        viewModelScope.launch {
            try {
                resultUseCase.invoke(result)
            } catch (e: Exception) {
                Log.e("YODA",e.toString())
            }
        }
    }
}



