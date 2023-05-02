package com.example.mathapp.ui.exam.composable.ResultComposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(totalQuestions: Int, numCorrectAnswers: Int) {
    val numIncorrectAnswers = totalQuestions - numCorrectAnswers
    val resultText = if (numCorrectAnswers == totalQuestions) {
        "Perfect Score!"
    } else {
        "You got $numCorrectAnswers out of $totalQuestions questions correct"
    }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Quiz Completed!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = resultText, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(text = "Correct Answers: $numCorrectAnswers", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Incorrect Answers: $numIncorrectAnswers", fontSize = 18.sp)
        }
    }
}
