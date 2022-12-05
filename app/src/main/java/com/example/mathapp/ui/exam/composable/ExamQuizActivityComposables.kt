package com.example.mathapp.ui.exam.composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.ui.exam.ExamViewModel


@Composable
fun ProductsActivity(
    dataOrException: DataOrException<List<QuestionsModel>, Exception>,
    viewModel: ExamViewModel
) {

    val products = dataOrException.data
    Log.d("yoda", products.toString())

    products?.let {
        LazyColumn {
            items(products) { quiz ->

                ProductCard(quiz = quiz)
            }
        }
    }

    val e = dataOrException.e
    e?.let {
        Text(
            text = e.message!!,
            modifier = Modifier.padding(16.dp)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressBar(
            isDisplayed = viewModel.loading.value
        )
    }
}
