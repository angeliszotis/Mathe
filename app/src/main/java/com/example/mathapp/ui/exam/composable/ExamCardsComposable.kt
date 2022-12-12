package com.example.mathapp.ui.exam.composable



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.ui.exam.ExamFragment
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.FbColor


@Composable
fun ProductCard(
    quiz: QuestionsModel
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
    ){Text(
        modifier = Modifier
            .fillMaxWidth(0.8f),
        //.align(Alignment.CenterHorizontally),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        text = quiz.answare.toString(),
        maxLines = 5
    )}


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                color = BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 64.dp,
                    topStart = 64.dp,
                    topEnd = 34.dp,
                    bottomStart = 34.dp,

                    )
            )
            //.align(Alignment.CenterHorizontally)
    ) {
        Spacer(modifier = Modifier.size(30.dp))


        cardas(quiz = quiz, opt = "op1")
        cardas(quiz = quiz, opt = "op2")
        cardas(quiz = quiz, opt = "op3")
        cardas(quiz = quiz, opt = "op4")

        Spacer(modifier = Modifier.size(30.dp))


    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun cardas(
    quiz: QuestionsModel,
    opt: String
) {

    Button(
        onClick = {  },
        shape = RoundedCornerShape(64.dp),
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(FbColor)


    ) {
        if (opt.equals("op1")) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                quiz.op1?.let { name ->
                    Text(
                        text = name,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .wrapContentWidth(Alignment.Start),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

            }
        } else if (opt.equals("op2")) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                quiz.op2?.let { name ->
                    Text(
                        text = name,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .wrapContentWidth(Alignment.Start),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

            }
        } else if (opt.equals("op3")) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                quiz.op3?.let { name ->
                    Text(
                        text = name,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .wrapContentWidth(Alignment.Start),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

            }
        } else if (opt.equals("op4")) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)
            ) {
                quiz.op4?.let { name ->
                    Text(
                        text = name,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .wrapContentWidth(Alignment.Start),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

            }
        }
    }
}

