package com.example.mathapp.ui.exam.composable



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.mathapp.data.model.DataOrException
import com.example.mathapp.data.model.QuestionsModel
import com.example.mathapp.ui.exam.ExamViewModel



private var ans2 :String = " "
@Composable
fun TitleRet(
    dataOrException: DataOrException<List<QuestionsModel>, Exception>,
) {

    val products = dataOrException.data

    products?.let {
        LazyColumn {
            items(products) { quiz ->

               // getit(quiz = quiz)
                ans2=quiz.answare.toString()

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

fun getit( ):String{

    return ans2
}

