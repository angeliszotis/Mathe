package com.example.mathapp.ui.exam.result.composables

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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.framework.result.model.ResultAnswerModel
import com.example.mathapp.ui.composable.LottieLoader.LottieLoaderResult
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingCustom_6dp
import com.example.mathapp.util.BASE_URL_LOTTIE_RESULTS_lf20_END

@Composable
fun ResultScreen(
    totalQuestions: Int,
    numCorrectAnswers: Int,
    remainingTime: Int,
    viewModel: ExamViewModel
) {

    val numIncorrectAnswers = totalQuestions - numCorrectAnswers
    val resultText = if (numCorrectAnswers == totalQuestions) {
        stringResource(id = R.string.perfect_score)
    } else {
        stringResource(id = R.string.perfect_score, numCorrectAnswers, totalQuestions)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 64.dp,
                    topStart = 64.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp
                )
            )
            .clip(RectangleShape)
            .padding(vertical = 25.dp, horizontal = 16.dp), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.complete), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = resultText, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Text(text = stringResource(id = R.string.correct, numCorrectAnswers) , fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.incorrect, numIncorrectAnswers), fontSize = 18.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = stringResource(id = R.string.time, remainingTime), fontSize = 18.sp)
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.save),fontWeight = FontWeight.Bold
        )
    }

    Row(modifier = Modifier.padding(vertical = 16.dp)) {
        Button(modifier = Modifier
            .weight(0.5f)
            .padding(SpacingCustom_6dp),
            colors = androidx.compose.material.ButtonDefaults.buttonColors(
                backgroundColor = FbColor
            ),
            onClick = {
                viewModel.insertExternalResult(
                    ResultAnswerModel(
                        corect = numCorrectAnswers,
                        incorect = numIncorrectAnswers,
                        time = remainingTime
                    )
                )
            }) {
            Text(color = Color.White, text = stringResource(id = R.string.score_external))
        }
        Button(modifier = Modifier
            .weight(0.5f)
            .padding(SpacingCustom_6dp),
            colors = androidx.compose.material.ButtonDefaults.buttonColors(
                backgroundColor = FbColor
            ), onClick = {
                viewModel.insertInternalResult(
                    ResultAnswerModel(
                        corect = numCorrectAnswers,
                        incorect = numIncorrectAnswers,
                        time = remainingTime
                    )
                )
            }) {
            Text(color = Color.White, text = stringResource(id = R.string.score_internal))
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieLoaderResult(link = BASE_URL_LOTTIE_RESULTS_lf20_END)
    }

}
