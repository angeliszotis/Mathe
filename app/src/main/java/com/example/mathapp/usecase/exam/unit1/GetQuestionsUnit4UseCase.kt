package com.example.mathapp.usecase.exam.unit1
import com.example.mathapp.domain.exam.QuestionRepository
import com.example.mathapp.framework.exam.model.QuestionModel
import javax.inject.Inject


class GetQuestionsUnit4UseCase @Inject constructor(
    private val questionRepository: QuestionRepository
) {
    fun invoke(): List<QuestionModel> {
        return questionRepository.getQuestionUnit2()
    }
}



