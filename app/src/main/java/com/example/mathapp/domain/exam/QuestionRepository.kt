package com.example.mathapp.domain.exam

import com.example.mathapp.framework.exam.model.QuestionModel

interface QuestionRepository {
    fun getQuestionUnit1(): List<QuestionModel>
    fun getQuestionUnit2(): List<QuestionModel>
    fun getQuestionUnit3(): List<QuestionModel>
    fun getQuestionUnit4(): List<QuestionModel>
    fun getQuestionUnit5(): List<QuestionModel>
    fun getQuestionUnit6(): List<QuestionModel>
    fun getQuestionUnit7(): List<QuestionModel>
    fun getQuestionUnit8(): List<QuestionModel>
}