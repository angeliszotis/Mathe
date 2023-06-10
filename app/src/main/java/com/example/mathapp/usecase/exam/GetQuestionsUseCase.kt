package com.example.mathapp.usecase.exam

import com.example.mathapp.domain.exam.QuestionRepository
import com.example.mathapp.framework.exam.model.Question
import javax.inject.Inject


class GetQuestionsUseCase @Inject constructor(
    private val questionRepository: QuestionRepository
) {
      fun invoke(): List<Question> {
        return questionRepository.getQuestion()
    }
}


