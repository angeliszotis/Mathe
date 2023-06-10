package com.example.mathapp.domain.exam

import com.example.mathapp.framework.exam.model.Question

interface QuestionRepository {
     fun getQuestion(): List<Question>
}