package com.example.mathapp.ui.result

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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.SpacingCustom_6dp

@Composable
fun ResultScreen(totalQuestions: Int, numCorrectAnswers: Int,remainingTime: Int , viewModel: ExamViewModel) {

    // val viewModel : ResultViewModel = viewModel()
    val numIncorrectAnswers = totalQuestions - numCorrectAnswers
    val resultText = if (numCorrectAnswers == totalQuestions) {
        "Perfect Score!"
    } else {
        "Πετυχες $numCorrectAnswers απο τις $totalQuestions σωστές ερωτησεις"
    }
    Column(modifier = Modifier
        .fillMaxWidth()
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
        .padding(vertical = 25.dp), verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
    ){
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

    Row(modifier = Modifier.padding(16.dp)) {
        Button(modifier = Modifier
            .weight(0.5f)
            .padding(SpacingCustom_6dp),
            onClick = { viewModel.insertResult(ResultModel("takis","lakis","makis"))
                 }) {
            Text(text = "Αποθηκευση")
        }
        Button(modifier = Modifier
            .weight(0.5f)
            .padding(SpacingCustom_6dp), onClick = { /*TODO*/ }) {
            Text(text = "Κοινοποιηση")
        }
    }


}
