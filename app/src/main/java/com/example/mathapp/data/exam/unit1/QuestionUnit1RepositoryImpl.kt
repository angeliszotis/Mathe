package com.example.mathapp.data.exam.unit1

import com.example.mathapp.MathAppApplication
import com.example.mathapp.R
import com.example.mathapp.domain.exam.unit1.QuestionUnit1Repository
import com.example.mathapp.framework.exam.model.QuestionModel
import com.google.gson.Gson
import javax.inject.Inject


class QuestionUnit1RepositoryImpl @Inject constructor() : QuestionUnit1Repository {
    override fun getQuestion(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }
}