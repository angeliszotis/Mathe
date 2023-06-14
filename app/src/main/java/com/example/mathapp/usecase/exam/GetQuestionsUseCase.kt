package com.example.mathapp.usecase.exam

import com.example.mathapp.domain.exam.QuestionRepository
import com.example.mathapp.framework.exam.model.QuestionModel
import javax.inject.Inject


class GetQuestionsUseCase @Inject constructor(
    private val questionRepository: QuestionRepository
) {
      fun invoke(): List<QuestionModel> {
        return questionRepository.getQuestion()
    }
}


