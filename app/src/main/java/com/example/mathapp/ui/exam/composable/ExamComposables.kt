package com.example.mathapp.ui.exam.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.ui.composable.ButtonItem.ButtonItem
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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
                        .fillMaxWidth(0.25f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Left,
                    text = "Ερώτηση 1/10",
                    maxLines = 1,
                )

                Spacer(modifier = Modifier.size(100.dp, 0.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.67f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Right,
                    text = "Χρόνος 10:00",
                    maxLines = 1,
                )
            }


        }

        Spacer(modifier = Modifier.size(10.dp))

        ProductsActivity(dataOrException, viewModel)

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



        }


    }
}

/*
@Composable
fun RadiosButtans(){

    RadioButton(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .semantics { contentDescription = "Localized Description" },
        selected = false,
        onClick = { true },
    )
    RadioButton(
        selected = !true,
        onClick = { false },
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
            .semantics { contentDescription = "Localized Description" })

    RadioButton(
        modifier = Modifier
            .fillMaxWidth()

            .align(Alignment.CenterHorizontally)
            .semantics { contentDescription = "Localized Description" },
        selected = false,
        onClick = { true },
    )
    RadioButton(
        selected = !true,
        onClick = { false },
        modifier = Modifier
            .fillMaxWidth()

            .align(Alignment.CenterHorizontally)
            .semantics { contentDescription = "Localized Description" })

}
*/


