package com.example.mathapp.ui.exam.composable


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.data.users.QuestionsModel
import com.example.mathapp.ui.theme.BabyBluePurple2

@Composable
fun ProductCard(
    quiz: QuestionsModel,
    onAnswerSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                color = BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 64.dp,
                    topStart = 64.dp,
                    topEnd = 64.dp,
                    bottomStart = 64.dp,
                    )
            )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            //.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            text = quiz.answare.toString(),
            maxLines = 5
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding( horizontal = 8.dp, vertical = 22.dp)
            .background(
                color = BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 34.dp,
                    topStart = 34.dp,
                    topEnd = 34.dp,
                    bottomStart = 34.dp,

                    )
            )
        //.align(Alignment.CenterHorizontally)
    ) {
        //Spacer(modifier = Modifier.size(30.dp))
        SingleChoiceQuestion(quiz,  selectedAnswer = "", onAnswerSelected = onAnswerSelected)
        Button(onClick = { /*TODO*/ }) {

        }
        //Spacer(modifier = Modifier.size(30.dp))
    }
}

@Composable
private fun SingleChoiceQuestion(
    question: QuestionsModel,
    selectedAnswer: String = "",
     onAnswerSelected: (String) -> Unit,
) {
    val radioOptions = listOf(question.op1, question.op2, question.op3, question.op4)
    val (selectedOption, onOptionSelected) = remember(selectedAnswer) {
        mutableStateOf(selectedAnswer)
    }

        radioOptions.forEach { answer ->
            val onClickHandle = {
                onOptionSelected(answer.toString())
                onAnswerSelected(answer.toString())
            }
            val optionSelected = answer == selectedOption
            val answerBorderColor = if (optionSelected) {
                MaterialTheme.colors.primary.copy(alpha = 0.5f)
            } else {
                //MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
                BabyBluePurple2
            }
            val answerBackgroundColor = if (optionSelected) {
                MaterialTheme.colors.primary.copy(alpha = 0.12f)
            } else {
                MaterialTheme.colors.background
            }
            Surface(
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(
                    width = 8.dp,
                    color = answerBorderColor
                ),
                modifier = Modifier.padding(vertical = 8.dp),

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .selectable(
                            selected = optionSelected,
                            onClick = onClickHandle
                        )
                        .background(answerBackgroundColor)
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(4f),
                        text = answer.toString()
                    )
                    RadioButton(
                        modifier = Modifier.weight(1f),
                        selected = optionSelected,
                        onClick = onClickHandle,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.primary
                        )
                    )
                }
            }
        }
}

