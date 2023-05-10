package com.example.mathapp.ui.exam.composable.Result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
fun ResultScreen(totalQuestions: Int, numCorrectAnswers: Int,remainingTime: Int) {
    val numIncorrectAnswers = totalQuestions - numCorrectAnswers
    val resultText = if (numCorrectAnswers == totalQuestions) {
        "Perfect Score!"
    } else {
        "Πετυχες $numCorrectAnswers απο τις $totalQuestions σωστές ερωτησεις"
    }
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = "Quiz Ολοκληρώθηκε!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = resultText, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Text(text = "Σωστές: $numCorrectAnswers", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Λάθος: $numIncorrectAnswers", fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Χρόνος: $remainingTime", fontSize = 18.sp)
        }
    }
}
