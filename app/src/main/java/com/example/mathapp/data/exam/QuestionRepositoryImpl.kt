package com.example.mathapp.data.exam

import com.example.mathapp.MathAppApplication
import com.example.mathapp.R
import com.example.mathapp.domain.exam.QuestionRepository
import com.example.mathapp.framework.exam.model.QuestionModel
import com.google.gson.Gson
import javax.inject.Inject


class QuestionRepositoryImpl @Inject constructor() : QuestionRepository {
    override fun getQuestionUnit1(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions1).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit2(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit3(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit4(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit5(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit6(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit7(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }

    override fun getQuestionUnit8(): List<QuestionModel> {
        val context = MathAppApplication.instance.applicationContext
        val jsonString = context.resources.openRawResource(R.raw.questions2).bufferedReader()
            .use { it.readText() }
        return Gson().fromJson(jsonString, Array<QuestionModel>::class.java).toList()
    }
}