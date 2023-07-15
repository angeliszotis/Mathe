package com.example.mathapp.ui.exam.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.exam.result.composables.ResultScreen
import com.example.mathapp.ui.theme.BabyBluePurple1
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple4
import com.example.mathapp.ui.theme.FbColor
import kotlinx.coroutines.delay

private var _globalReturntime = 0

@Composable
fun QuizScreen(viewModel: ExamViewModel,  unit: Int, changeMusic: (Int) -> Unit) {

    val randomQuestions = if (unit == 1){viewModel.randomQuestions} else { viewModel.randomQuestions2}
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    Column(modifier = Modifier.background(color = BabyBluePurple3,).fillMaxWidth().padding(5.dp)) {

        ProgressBar(currentQuestionIndex, randomQuestions.size)
        if (showResult) {
            ResultScreen(randomQuestions.size, score, _globalReturntime, viewModel = viewModel, unit = unit)
            changeMusic(R.raw.complete)
        }
        else if (currentQuestionIndex < randomQuestions.size) {
            val currentQuestion = randomQuestions[currentQuestionIndex]
            QuizContent(
                questionModel = currentQuestion,
                onNext = {
                    currentQuestionIndex++
                    if (currentQuestionIndex == randomQuestions.size) {
                        showResult = true
                    }
                },
                onShowResult = { showResult = true },
                onAnswer = { isCorrect -> if (isCorrect) { score++ } }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun QuizContent(
    questionModel: QuestionModel,
    onNext: () -> Unit,
    onShowResult: () -> Unit,
    onAnswer: (Boolean) -> Unit
) {
    var selectedAnswerIndex by remember { mutableStateOf(-1) }
    var showAnswer by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {
        Column(modifier = Modifier.background(color = BabyBluePurple2, RoundedCornerShape(12.dp)).fillMaxWidth().padding(5.dp)
        ) {
            Text(text = questionModel.text, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            questionModel.answers.forEachIndexed { index, answer ->
                AnswerButton(
                    text = answer,
                    isSelected = index == selectedAnswerIndex,
                    onClick = {
                        selectedAnswerIndex = index
                        if (index == questionModel.correctAnswerIndex) { showAnswer = false } }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (selectedAnswerIndex >= 0) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = FbColor),
                    onClick = {
                        if (selectedAnswerIndex == questionModel.correctAnswerIndex) {
                            onAnswer(true)

                        } else {
                            onAnswer(false)
                        }
                        onNext()
                        selectedAnswerIndex = -1 // reset the selected option
                        showButton = false // hide the help button after answering
                    }
                ) {
                    Text(color = Color.White, text = "Επόμενη")
                }
            } else {
                Spacer(modifier = Modifier.width(100.dp))
            }
            Timer(
                durationSeconds = 0,
                onTimeUp = {
                    onAnswer(false)
                    onShowResult() }
            )
            if (showButton) { Button(onClick = { showAnswer = true }) { Text(text = "Help") } }
        }
        if (showAnswer) {
            Text(text = "The correct answer is: ${questionModel.answers[questionModel.correctAnswerIndex]}", color = MaterialTheme.colors.secondary, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
        }
    }
}

@Composable
fun Timer(durationSeconds: Int, onTimeUp: () -> Unit) {
    var remainingTime by remember { mutableStateOf(durationSeconds) }

    LaunchedEffect(remainingTime) {
        while (remainingTime < 1000) {
            delay(1000L)
            remainingTime++
            _globalReturntime = remainingTime
        }
        onTimeUp()
    }

    Text(text = "Χρόνος : ${remainingTime} ″ ", fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isSelected) BabyBluePurple4 else BabyBluePurple1),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, fontSize = 10.sp)
    }
}

@Composable
fun ProgressBar(currentIndex: Int, totalQuestions: Int) {

    val progress = (currentIndex) / totalQuestions.toFloat()
    val percent = (progress * 100).toInt()

    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        if (currentIndex == totalQuestions) {
            Text(text = "Ερώτηση $currentIndex απο $totalQuestions", fontSize = 18.sp)
        } else {
            Text(text = "Ερώτηση ${currentIndex + 1} απο $totalQuestions", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(progress = progress, modifier = Modifier.fillMaxWidth(), color = FbColor)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$percent% Ολοκληρωμένο", fontSize = 14.sp, textAlign = TextAlign.End)
    }
}