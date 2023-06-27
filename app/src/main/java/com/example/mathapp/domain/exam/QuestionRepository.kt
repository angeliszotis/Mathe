package com.example.mathapp.domain.exam

import com.example.mathapp.framework.exam.model.QuestionModel

interface QuestionRepository {
    fun getQuestion(): List<QuestionModel>
}