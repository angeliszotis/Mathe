package com.example.mathapp.ui.exam.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.framework.exam.model.QuestionModel
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.exam.result.composables.ResultScreen
import com.example.mathapp.ui.theme.BabyBluePurple1
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple4
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingDefault_16dp
import com.example.mathapp.util.BASE_URL_LOTTIE_QUIZ_lf20_END1
import com.example.mathapp.util.BASE_URL_LOTTIE_QUIZ_lf20_END2
import com.example.mathapp.util.BASE_URL_LOTTIE_QUIZ_lf20_END3
import kotlinx.coroutines.delay
import kotlin.random.Random


private var privateReturntime = 0
private var privateCorrect : Boolean =false
private var privateTextCorrect : String = ""
private  var privateText50_50 : String = ""

@Composable
fun QuizScreen(viewModel: ExamViewModel,  unit: Int, changeMusic: (Int) -> Unit) {

    val randomQuestions = viewModel.randomQuestionModels.observeAsState(listOf()).value
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }

    var score by remember { mutableStateOf(0) }

    Column(modifier = Modifier
        .background(color = BabyBluePurple3)
        .fillMaxWidth()
        .padding(5.dp)) {

        ProgressBar(currentQuestionIndex, randomQuestions.size)
        if (showResult) {
            ResultScreen(randomQuestions.size, score, privateReturntime, viewModel = viewModel, unit = unit)
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
fun QuizContent(questionModel: QuestionModel, onNext: () -> Unit, onShowResult: () -> Unit, onAnswer: (Boolean) -> Unit) {

    var selectedAnswerIndex by remember { mutableStateOf(-1) }

    var showAnswerCall by remember { mutableStateOf(false) }
    val showButtonCallClicked = remember { mutableStateOf(false) }
    val showButtonCallEnabled = remember { derivedStateOf { !showButtonCallClicked.value } }

    var showAnswerGroup by remember { mutableStateOf(false) }
    val showButtonGroupClicked = remember { mutableStateOf(false) }
    val showButtonGroupEnabled = remember { derivedStateOf { !showButtonGroupClicked.value } }

    var showMinus by remember { mutableStateOf(false) }
    val showButtonMinusClicked = remember { mutableStateOf(false) }
    val showButtonMinusEnabled = remember { derivedStateOf { !showButtonMinusClicked.value } }

    val questionItems = remember(questionModel.answers) {
        questionModel.answers.shuffled()
    }


    Column(modifier = Modifier.padding(16.dp)) {
        Column(modifier = Modifier
            .background(color = BabyBluePurple2, RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(5.dp)) {

            Text(text = questionModel.text, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {

            questionItems.forEachIndexed { index, answer ->
                if(answer.isCorrect){ privateTextCorrect = answer.text }
                if(questionItems[Math.random().toInt()].text != privateTextCorrect){ privateText50_50 = questionItems[Math.random().toInt()].text }
                AnswerButton(
                    text = answer.text,
                    isSelected = index == selectedAnswerIndex,
                    onClick = {
                        privateCorrect= answer.isCorrect
                        selectedAnswerIndex = index
                        if (showAnswerCall) { showAnswerCall = false }
                        if(showAnswerGroup){ showAnswerGroup = false }
                        if(showMinus){ showMinus = false }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            if (selectedAnswerIndex >= 0) {
                Button(
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = FbColor),
                    onClick = {
                        onAnswer(privateCorrect)
                        onNext()
                        selectedAnswerIndex = -1
                        if (showAnswerCall) { showAnswerCall = false }
                        if(showAnswerGroup){ showAnswerGroup = false }
                        if(showMinus){ showMinus = false }
                    }
                ) {
                    Text(color = Color.White, text = stringResource(id = R.string.next))
                }
            }
            else { Spacer(modifier = Modifier.width(100.dp)) }
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    showMinus = true
                    showButtonMinusClicked.value = true
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (showButtonMinusEnabled.value) FbColor else Color.Gray),
                enabled = showButtonMinusEnabled.value
            ) {
                Text(color = Color.White, text = "-1")
            }
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    showAnswerGroup = true
                    showButtonGroupClicked.value = true
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (showButtonGroupEnabled.value) FbColor else Color.Gray),
                enabled = showButtonGroupEnabled.value
            ) {
                Icon( modifier = Modifier.size(25.dp),painter = painterResource(id = R.drawable.round_group_24), contentDescription = "Help", tint = Color.White)
            }
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    showAnswerCall = true
                    showButtonCallClicked.value = true
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = if (showButtonCallEnabled.value) FbColor else Color.Gray),
                enabled = showButtonCallEnabled.value
            ) {
                Icon( modifier = Modifier.size(25.dp),painter = painterResource(id = R.drawable.baseline_call_24), contentDescription = "Help", tint = Color.White)
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = BabyBluePurple2, RoundedCornerShape(12.dp))
            .padding(SpacingDefault_16dp), verticalArrangement = Arrangement.Center) {
            Timer(
                durationSeconds = 0,
                onTimeUp = {
                    onAnswer(false)
                    onShowResult()
                }
            )
            if(showAnswerCall){
                Row(modifier = Modifier.fillMaxWidth()) {
                    LottieLoader(modifier =Modifier.weight(0.3f) ,link = BASE_URL_LOTTIE_QUIZ_lf20_END1)
                    Text(modifier = Modifier
                        .weight(0.6f)
                        .fillMaxWidth()
                        .padding(SpacingDefault_16dp), textAlign = TextAlign.Center, text = "Μου φενετε πως ειναι το : \n\n"+privateTextCorrect)
                }
            }

            if(showAnswerGroup){
                val rand : Int = Random.nextInt(2)
                if(rand == 1){
                    Row(modifier = Modifier.fillMaxWidth()) {
                        LottieLoader(modifier =Modifier.weight(0.3f),link = BASE_URL_LOTTIE_QUIZ_lf20_END2)
                        Text(modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth()
                            .padding(SpacingDefault_16dp), textAlign = TextAlign.Center, text = "Σίγουρα είναι το :\n"+privateTextCorrect+ "\n η το\n" + privateText50_50)
                    }
                }else{
                    Row(modifier = Modifier.fillMaxWidth()) {
                        LottieLoader(modifier =Modifier.weight(0.3f),link = BASE_URL_LOTTIE_QUIZ_lf20_END2)
                        Text(modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth()
                            .padding(SpacingDefault_16dp), textAlign = TextAlign.Center, text = "Είμαστε ανάμεσα στο :\n" +privateText50_50+" ή στο " + privateTextCorrect)
                    }
                }
            }
            if(showMinus){
                Row(modifier = Modifier.fillMaxWidth()) {
                    LottieLoader(modifier = Modifier.weight(0.3f), link = BASE_URL_LOTTIE_QUIZ_lf20_END3)
                    Text(
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth()
                            .padding(SpacingDefault_16dp),
                        textAlign = TextAlign.Center,
                        color = Color.Red,
                        text = "Σίγουρα δεν είναι το :\n" + privateText50_50
                    )
                }
            }
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
            privateReturntime = remainingTime
        }
        onTimeUp()
    }

    Text(text = stringResource(id = R.string.time, remainingTime), fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

}

@Composable
fun AnswerButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isSelected) BabyBluePurple4 else BabyBluePurple1),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) { Text(text = text, fontSize = 10.sp) }
}

@Composable
fun ProgressBar(currentIndex: Int, totalQuestions: Int) {

    val progress = (currentIndex) / totalQuestions.toFloat()
    val percent = (progress * 100).toInt()

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        if (currentIndex == totalQuestions) { Text( text = stringResource(R.string.question_number, currentIndex, totalQuestions), fontSize = 18.sp) }
        else { Text(text = stringResource(R.string.question_number, currentIndex + 1,totalQuestions), fontSize = 18.sp) }
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(progress = progress, modifier = Modifier.fillMaxWidth(), color = FbColor)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.completed_percent, percent), fontSize = 14.sp, textAlign = TextAlign.End)
    }
}