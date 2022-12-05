package com.example.mathapp.data.model

data class DataOrException<T, E : Exception?>(
    var data: T? = null,
    var e: E? = null
)