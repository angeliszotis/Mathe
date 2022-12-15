package com.example.mathapp.ui.exam.composable


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel


private var ans2: String = " "

@Composable
fun TitleRet(
    dataOrException: DataOrException<List<QuestionsModel>, Exception>,
) {

    val products = dataOrException.data

    products?.let {
        LazyColumn {
            items(products) { quiz ->

                ans2 = quiz.answare.toString()

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
}



