package com.example.mathapp.ui.exam.result.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.framework.achievment.model.AchievementModel
import com.example.mathapp.framework.result.model.ResultAnswerModel
import com.example.mathapp.ui.composable.LottieLoader.LottieLoaderResult
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingCustom_6dp
import com.example.mathapp.ui.theme.SpacingDefault_16dp
import com.example.mathapp.ui.theme.SpacingHalf_8dp
import com.example.mathapp.util.BASE_URL_LOTTIE_RESULTS_lf20_END
import com.example.mathapp.util.BASE_URL_LOTTIE_RESULTS_lf20_END2
import com.example.mathapp.util.BASE_URL_LOTTIE_RESULTS_lf20_END3
import com.example.mathapp.util.achievementItems
import com.example.mathapp.util.showToast

@Composable
fun ResultScreen(totalQuestions: Int, numCorrectAnswers: Int, remainingTime: Int, viewModel: ExamViewModel, unit: Int) {

    val context = LocalContext.current

    val externalButtonClicked = remember { mutableStateOf(false) }
    var alertBool = remember { mutableStateOf(false) }
    val internalButtonClicked = remember { mutableStateOf(false) }
    val externalButtonEnabled = remember { derivedStateOf { !externalButtonClicked.value } }
    val internalButtonEnabled = remember { derivedStateOf { !internalButtonClicked.value } }

    val scoreList by viewModel.internalScore.observeAsState()
    val totalConsPoints = 10
    var point by remember(numCorrectAnswers, viewModel.internalScore) {
        val pointString: String? = viewModel.internalScore.value?.lastOrNull()?.point
        if (numCorrectAnswers >= 10) {
            if (pointString.isNullOrEmpty()) {
                mutableStateOf(1)
            } else {
                mutableStateOf(pointString.toInt() + 1)
            }
        } else {
            if (!pointString.isNullOrEmpty()) {
                mutableStateOf(pointString.toInt())
            } else {
                mutableStateOf(0)
            }
        }
    }
    val achievementShown = rememberUpdatedState(scoreList?.lastOrNull()?.point?.toInt() == totalConsPoints && alertBool.value)

    val toastMessage: String? = viewModel.toastMessage.value
    val numIncorrectAnswers = totalQuestions - numCorrectAnswers

    val resultText =
        if (numCorrectAnswers == totalQuestions) {
            stringResource(id = R.string.perfect_score, numCorrectAnswers, totalQuestions)
        } else {
            stringResource(id = R.string.perfect_score, numCorrectAnswers, totalQuestions)
        }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(BabyBluePurple2, RoundedCornerShape(bottomEnd = 64.dp, topStart = 64.dp, topEnd = 20.dp, bottomStart = 20.dp))
            .clip(RectangleShape)
            .padding(vertical = 25.dp, horizontal = 16.dp), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.complete), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = resultText, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Text(text = stringResource(id = R.string.correct, numCorrectAnswers), fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.incorrect, numIncorrectAnswers), fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.time, remainingTime), fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.score_point, point.toString()), fontSize = 18.sp)
        }
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = stringResource(id = R.string.save), fontWeight = FontWeight.Bold)
    }

    Row(modifier = Modifier.padding(vertical = 16.dp)) {
        Button(
            modifier = Modifier
                .weight(0.5f)
                .padding(SpacingCustom_6dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = if (externalButtonEnabled.value) FbColor else Color.Gray),
            onClick = {
                if (externalButtonEnabled.value) {
                    viewModel.insertExternalResult(
                        ResultAnswerModel(corect = numCorrectAnswers, incorect = numIncorrectAnswers, time = remainingTime, point = point.toString()),
                        unit
                    )
                    externalButtonClicked.value = true
                }
            },
            enabled = externalButtonEnabled.value
        ) {
            Text(color = Color.White, text = stringResource(id = R.string.score_external))
        }
        Button(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .weight(0.5f)
                .padding(SpacingCustom_6dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = if (internalButtonEnabled.value) FbColor else Color.Gray),
            onClick = {
                if (internalButtonEnabled.value) {
                    viewModel.insertInternalResult(
                        ResultAnswerModel(corect = numCorrectAnswers, incorect = numIncorrectAnswers, time = remainingTime, point = point.toString()),
                        unit
                    )
                    internalButtonClicked.value = true
                    toastMessage?.let { showToast(context = context, message = it) }
                    if (!scoreList.isNullOrEmpty() &&
                        point == totalConsPoints &&
                        scoreList?.get(scoreList!!.size -1)?.point?.toInt() != totalConsPoints) {
                        alertBool.value = true
                    }

                }
            },
            enabled = internalButtonEnabled.value
        ) {
            Text(color = Color.White, text = stringResource(id = R.string.score_internal))
        }
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (numCorrectAnswers < 6) {
            LottieLoaderResult(link = BASE_URL_LOTTIE_RESULTS_lf20_END3)
        } else if (numCorrectAnswers < 10) {
            LottieLoaderResult(link = BASE_URL_LOTTIE_RESULTS_lf20_END2)
        } else {
            LottieLoaderResult(link = BASE_URL_LOTTIE_RESULTS_lf20_END)
        }
    }

    if (!scoreList.isNullOrEmpty()  && achievementShown.value) {
        achievementItems.forEach { item ->
            if (item.unit == unit) {
                AchievementAlertDialog(item)
            }
        }
    }
}


@Composable
fun AchievementAlertDialog(achievement: AchievementModel) {
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxSize(0.9f)
                .background(BabyBluePurple2, RoundedCornerShape(SpacingDefault_16dp)),
            onDismissRequest = { showDialog = false },
            title = {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Συχαριτηρια Ξεκληδωσες")
                }
            },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = stringResource(id = achievement.title),
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
                    )
                    Image(
                        painter = painterResource(achievement.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "(" + stringResource(id = achievement.date) + ")",
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = stringResource(id = achievement.info),
                        modifier = Modifier.padding(top = SpacingHalf_8dp)
                    )
                }
            },
            confirmButton = {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(
                        shape = RoundedCornerShape(SpacingDefault_16dp),
                        onClick = { showDialog = false },
                        colors = ButtonDefaults.buttonColors(backgroundColor = FbColor)
                    ) {
                        Text(text = "Τέλεια", color = Color.White)
                    }
                }
            },
            dismissButton = {}
        )
    }
}
