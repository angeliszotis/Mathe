package com.example.mathapp.domain.exam.unit1

import com.example.mathapp.framework.exam.model.QuestionModel

interface QuestionUnit1Repository {
    fun getQuestion(): List<QuestionModel>
}