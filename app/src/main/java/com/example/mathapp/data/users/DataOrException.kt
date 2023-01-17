package com.example.mathapp.data.users

data class DataOrException<T, E : Exception?>(
    var data: T? = null,
    var e: E? = null
)