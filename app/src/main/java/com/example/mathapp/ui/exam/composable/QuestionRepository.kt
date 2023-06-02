package com.example.mathapp.ui.exam.composable

import com.example.mathapp.MathAppApplication
import com.example.mathapp.R
import com.google.gson.Gson

class QuestionRepository {
    fun getQuestions(): List<Question> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions).bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, Array<Question>::class.java).toList()
    }
}