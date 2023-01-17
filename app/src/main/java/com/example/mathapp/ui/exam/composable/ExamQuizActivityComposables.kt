package com.example.mathapp.ui.exam.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mathapp.data.users.DataOrException
import com.example.mathapp.data.users.QuestionsModel
import com.example.mathapp.ui.exam.ExamViewModel

@Composable
fun ProductsActivity(
    questiosndata: DataOrException<List<QuestionsModel>, Exception>,
    viewModel: ExamViewModel
) {


    val products = questiosndata.data

    products?.let {
        LazyColumn {
            items(products) { quiz ->

                ProductCard(quiz = quiz)

            }
        }
    }

    val e = questiosndata.e
    e?.let {
        Text(
            text = e.message!!,
            modifier = Modifier.padding(16.dp)
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressBar(
            isDisplayed = viewModel.loading.value
        )
    }
}

