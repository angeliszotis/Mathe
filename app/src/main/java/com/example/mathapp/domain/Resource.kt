package com.example.mathapp.domain

import com.example.mathapp.data.users.QuestionsModel


sealed class Resource<QuestionsModel>(val data: QuestionsModel? = null, val error: String? = null) {
    class Success<QuestionsModel>(data: QuestionsModel) : Resource<QuestionsModel>(data = data)
    class Error<QuestionsModel>(error: String, data: QuestionsModel? = null) :
        Resource<QuestionsModel>(data = data, error = error)
}