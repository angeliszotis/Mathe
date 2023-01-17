package com.example.mathapp.ui.exam.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.data.users.DataOrException
import com.example.mathapp.data.users.QuestionsModel
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.ui.profile.composable.Timer
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// UI exam arxiki

@Composable
fun ExamScreen(
    questiosndata: DataOrException<List<QuestionsModel>, Exception>,
    viewModel: ExamViewModel
) {
    //dbtest()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
    ) {

        //TitleRet(questiosndata)

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

            }


        }

        Spacer(modifier = Modifier.size(10.dp))

        ProductsActivity(questiosndata, viewModel)

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
                    .size(200.dp)
                    .align(CenterHorizontally)
            )
        }

    }
}

fun dbtest() {
    val db = Firebase.firestore
    val cities = db.collection("unit1")

    for (i in 1..20) {
        val data1 = hashMapOf(
            "id" to i.toString(),
            "answare" to i.toString(),
            "op1" to "1",
            "op2" to "2",
            "op3" to "3",
            "op4" to "4",
            "question" to "Pio dialegis 1-2-3-4"
        )
        cities.document(i.toString()).set(data1)
    }


}




