package com.example.mathapp.framework.result.model

data class ResultModel(
    var name: String,
    var surname: String,
    var school: String,
    var correct: String,
    var incorrect: String,
    var time: String

)

data class ResultAnswerModel(
    var corect: Int,
    var incorect: Int,
    var time: Int
)