package com.example.mathapp.ui.exam

import androidx.lifecycle.ViewModel
import com.example.mathapp.framework.exam.model.Question
import com.example.mathapp.usecase.exam.GetQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExamViewModel @Inject constructor(
      getQuestionsUseCase: GetQuestionsUseCase
) : ViewModel() {

        private val questions = getQuestionsUseCase.invoke()
        val randomQuestions = getRandomQuestions(questions)

    private fun getRandomQuestions(questions: List<Question>): List<Question> {
        val randomQuestions = mutableListOf<Question>()
        val usedIds = mutableSetOf<Int>()
        while (randomQuestions.size < 12 && usedIds.size < questions.size) {
            val question = questions.random()
            if (question.id !in usedIds && question !in randomQuestions) {
                usedIds.add(question.id)
                randomQuestions.add(question)
            }
        }
        return randomQuestions
    }
}



