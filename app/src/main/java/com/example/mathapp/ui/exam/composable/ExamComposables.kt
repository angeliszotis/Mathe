package com.example.mathapp.ui.exam.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.profile.composable.Timer
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5

// UI exam arxiki

@Composable
fun ExamScreen(
    dataOrException: DataOrException<List<QuestionsModel>, Exception>,
    viewModel: ExamViewModel
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
    ) {

        TitleRet(dataOrException)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = BabyBluePurple2,
                    RoundedCornerShape(
                        bottomEnd = 0.dp,
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,

                        )
                )
        )

        {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.45f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left,
                    text = "Ερώτηση 1/10",
                    maxLines = 1,
                )

                Spacer(modifier = Modifier.size(100.dp, 0.dp))

               /* Text(
                    modifier = Modifier
                        .fillMaxWidth(0.67f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Right,
                    text = "Χρόνος 10:00",
                    maxLines = 1,
                )*/
            }


        }

        Spacer(modifier = Modifier.size(10.dp))

        ProductsActivity(dataOrException, viewModel)
/*
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            ButtonItem(modifier = Modifier
                .fillMaxWidth(0.5f)
                .weight(0.5f), text ="Προηγούμενο" )

            Spacer(modifier = Modifier.size(20.dp))

            ButtonItem(modifier = Modifier
                .fillMaxWidth(0.5f)
                .weight(0.5f), text ="Επόμενο" )



        }*/
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Timer(
                totalTime = 100L * 1000L,
                handleColor = BabyBluePurple5,
                inactiveBarColor = Color.DarkGray,
                activeBarColor = BabyBluePurple5,
                modifier = Modifier
                    .size(200.dp).align(CenterHorizontally)
            )
        }

    }
}




