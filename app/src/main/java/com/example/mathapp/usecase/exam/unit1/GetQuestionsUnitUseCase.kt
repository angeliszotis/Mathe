package com.example.mathapp.usecase.exam.unit1

import com.example.mathapp.domain.exam.QuestionRepository
import com.example.mathapp.framework.exam.model.QuestionModel
import javax.inject.Inject


class GetQuestionsUnitUseCase @Inject constructor(
    private val repository: QuestionRepository
) {
    fun invoke( unit:Int): List<QuestionModel> {
       return when (unit) {
            1 -> repository.getQuestionUnit1()
            2 -> repository.getQuestionUnit2()
            3 -> repository.getQuestionUnit3()
            4 -> repository.getQuestionUnit4()
            5 -> repository.getQuestionUnit5()
            6 -> repository.getQuestionUnit6()
            7 -> repository.getQuestionUnit7()
            8 -> repository.getQuestionUnit8()
            else -> {repository.getQuestionUnit1()}
        }
    }
}


