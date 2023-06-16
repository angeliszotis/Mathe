package com.example.mathapp.ui.score.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.mathapp.ui.score.ScoreViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2

@Composable
fun ScoreScreen(viewModel: ScoreViewModel) {
    val scoreList by viewModel.score.observeAsState()
    LazyColumn(
        modifier = Modifier
            .padding(vertical = 25.dp)
            .fillMaxWidth()
            .background(
                BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 80.dp,
                    topStart = 80.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp
                )
            )
            .clip(RectangleShape), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        scoreList?.let { list ->
            items(list) { item ->
                Row {
                    Text(text = item.name)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = item.surname)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = item.school)
                }
            }
        }
    }
}