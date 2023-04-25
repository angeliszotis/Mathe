package com.example.mathapp.ui.exam.model

data class ExamDataOrException<T, E : Exception?>(
    var data: T? = null,
    var e: E? = null
)