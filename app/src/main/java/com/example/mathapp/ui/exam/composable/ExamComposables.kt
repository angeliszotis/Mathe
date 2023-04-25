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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun ExamScreen() {

    val questions = listOf(
        Question("What is the capital of France?", listOf("Paris", "Berlin", "Rome"), 0),
        Question("What is the highest mountain in the world?", listOf("Mount Everest", "K2", "Makalu"), 0),
        Question("What is the largest country in the world by area?", listOf("Russia", "Canada", "China"), 0)
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    if (showResult) {
        ResultScreen(score, questions.size)
    } else if (currentQuestionIndex < questions.size) {
        val currentQuestion = questions[currentQuestionIndex]
        QuizScreen(
            question = currentQuestion,
            onNext = {
                currentQuestionIndex++
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
}

@Composable
fun QuizScreen(question: Question, onNext: () -> Unit, onShowResult: () -> Unit, onAnswer: (Boolean) -> Unit) {
    var selectedAnswerIndex by remember { mutableStateOf(-1) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = question.text, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            question.answers.forEachIndexed { index, answer ->
                AnswerButton(
                    text = answer,
                    isSelected = index == selectedAnswerIndex,
                    onClick = { selectedAnswerIndex = index }
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
                            onNext()
                        } else {
                            onAnswer(false)
                            onShowResult()
                        }
                        selectedAnswerIndex = -1 // reset the selected option
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

    data class Question(val text: String, val answers: List<String>, val correctAnswerIndex: Int)
