package com.example.mathapp.data.exam

import com.example.mathapp.MathAppApplication
import com.example.mathapp.R
import com.example.mathapp.domain.exam.QuestionRepository
import com.example.mathapp.framework.exam.model.QuestionModel
import com.google.gson.Gson
import javax.inject.Inject


class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {
    override  fun getQuestion(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions).bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }
}