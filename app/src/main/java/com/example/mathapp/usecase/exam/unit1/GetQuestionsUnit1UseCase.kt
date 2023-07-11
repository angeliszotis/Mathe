package com.example.mathapp.usecase.exam.unit1

import com.example.mathapp.domain.exam.unit1.QuestionUnit1Repository
import com.example.mathapp.framework.exam.model.QuestionModel
import javax.inject.Inject


class GetQuestionsUnit1UseCase @Inject constructor(
    private val questionUnit1Repository: QuestionUnit1Repository
) {
    fun invoke(): List<QuestionModel> {
        return questionUnit1Repository.getQuestion()
    }
}


