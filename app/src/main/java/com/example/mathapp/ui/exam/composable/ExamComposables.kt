package com.example.mathapp.ui.exam.composable

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Composable
fun ExamScreen(viewModel: ExamViewModel) {
    val database =
        Firebase.database("https://mathapp-373cc-default-rtdb.europe-west1.firebasedatabase.app/")
//val myRef = database.getReference("quiz").child("unit1").child("q1")

    val quiz by viewModel.quiz.observeAsState(emptyList())



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .verticalScroll(rememberScrollState())
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = BabyBluePurple2,
                    RoundedCornerShape(
                        bottomEnd = 70.dp,
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 70.dp,

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
                        .fillMaxWidth(0.3f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 3.em,
                    textAlign = TextAlign.Left,
                    text = "Ερώτηση 1/10",
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.size(100.dp, 0.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.6f),
                    fontWeight = FontWeight.Bold,
                    fontSize = 3.em,
                    textAlign = TextAlign.Right,
                    text = "Χρόνος 10:00",
                    maxLines = 1,
                )
            }



            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(5.dp)
                    .background(color = BabyBluePurple3)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 3.5.em,
                textAlign = TextAlign.Center,
                text =     viewModel.onDataTake().toString(),
                maxLines = 5
            )
            Spacer(modifier = Modifier.size(10.dp))



        }
        Spacer(modifier = Modifier.size(30.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(
                    color = BabyBluePurple2,
                    RoundedCornerShape(
                        bottomEnd = 64.dp,
                        topStart = 64.dp,
                        topEnd = 34.dp,
                        bottomStart = 34.dp,

                        )
                )
                .align(Alignment.CenterHorizontally)
        ) {




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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .weight(0.5f),
                onClick = { /*TODO*/ },
                shape = CircleShape
            ) {
                Text(text = "Προηγούμενο")
            }
            Spacer(modifier = Modifier.size(20.dp))


            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .weight(0.5f),
                onClick = { /*TODO*/ },
                shape = CircleShape
            ) {
                Text(text = "Επόμενο")
            }

        }

    }


}

