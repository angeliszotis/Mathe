package com.example.mathapp.ui.exam.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.ui.exam.composable.ResultComposables.ResultScreen
import com.google.gson.Gson
import kotlinx.coroutines.delay
@Composable
fun ExamScreen() {
    val context = LocalContext.current
    val jsonString = context.resources.openRawResource(R.raw.questions).bufferedReader().use { it.readText() }
    val questions = Gson().fromJson(jsonString, Array<Question>::class.java).toList()

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    Column {
        ProgressBar(currentQuestionIndex, questions.size)
        if (showResult) {
            ResultScreen(score, questions.size)
        } else if (currentQuestionIndex < questions.size) {
            val currentQuestion = questions[currentQuestionIndex]
            QuizScreen(
                question = currentQuestion,
                onNext = {
                    currentQuestionIndex++
                    if (currentQuestionIndex == questions.size) {
                        showResult = true
                    }
                },
                onShowResult = {
                    showResult = true
                },
                onAnswer = { isCorrect ->
                    if (isCorrect) {
                        score++
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
@Composable
fun QuizScreen(
    question: Question,
    onNext: () -> Unit,
    onShowResult: () -> Unit,
    onAnswer: (Boolean) -> Unit
) {
    var selectedAnswerIndex by remember { mutableStateOf(-1) }
    var showAnswer by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = question.text, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            question.answers.forEachIndexed { index, answer ->
                AnswerButton(
                    text = answer,
                    isSelected = index == selectedAnswerIndex,
                    onClick = {
                        selectedAnswerIndex = index
                        if (index == question.correctAnswerIndex) {
                            showAnswer = false
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (selectedAnswerIndex >= 0) {
                Button(
                    onClick = {
                         if (selectedAnswerIndex == question.correctAnswerIndex) {
                            onAnswer(true)

                        } else {
                            onAnswer(false)
                        }
                        onNext()
                        selectedAnswerIndex = -1 // reset the selected option
                        showButton = false // hide the help button after answering
                    }
                ) {
                    Text(text = "Next")
                }
            } else {
                Spacer(modifier = Modifier.width(100.dp))
            }
            Timer(
                durationSeconds = 30,
                onTimeUp = {
                    onAnswer(false)
                    onShowResult()
                }
            )
            if (showButton) {
                Button(
                    onClick = {
                        showAnswer = true
                    }
                ) {
                    Text(text = "Help")
                }
            }
        }
        if (showAnswer) {
            Text(
                text = "The correct answer is: ${question.answers[question.correctAnswerIndex]}",
                color = MaterialTheme.colors.secondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun Timer(durationSeconds: Int, onTimeUp: () -> Unit) {
    var remainingTime by remember { mutableStateOf(durationSeconds) }

    LaunchedEffect(remainingTime) {
        while (remainingTime > 0) {
            delay(1000L)
            remainingTime--
        }
        onTimeUp()
    }

    Text(
        text = "Time Left: ${remainingTime}s",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )

}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) MaterialTheme.colors.secondary else MaterialTheme.colors.surface
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}

@Composable
fun ProgressBar(currentIndex: Int, totalQuestions: Int) {
    val progress = (currentIndex) / totalQuestions.toFloat()
    val percent = (progress * 100).toInt()
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        if(currentIndex == totalQuestions){
            Text(text = "Question $currentIndex of $totalQuestions", fontSize = 18.sp)
        }else{
            Text(text = "Question ${currentIndex + 1} of $totalQuestions", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = progress,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$percent% completed", fontSize = 14.sp, textAlign = TextAlign.End)
    }
}

    data class Question(val text: String, val answers: List<String>, val correctAnswerIndex: Int)
