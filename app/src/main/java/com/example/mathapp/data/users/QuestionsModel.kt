package com.example.mathapp.data.users

data class QuestionsModel(

    val answare: String? = "",
    val op1: String? = "",
    val op2: String? = "",
    val op3: String? = "",
    val op4: String? = "",
    val question: String? = "",

    )

data class Opt(
    val text: String
)