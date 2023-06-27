package com.example.mathapp.ui.score.internal.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mathapp.framework.result.model.ResultEntity
import com.example.mathapp.ui.score.ScoreViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3

@Composable
fun ScoreInternalScreen(viewModel: ScoreViewModel) {
    val scoreList by viewModel.readAllData.observeAsState()
    val expandedItemIndex = remember { mutableStateOf(-1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
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
                .clip(RectangleShape)
                .padding(vertical = 25.dp), verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Τοπικά Σκορ",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            scoreList?.let { list ->
                itemsIndexed(list) { index, item ->
                    if (index == expandedItemIndex.value) {
                        ScoreListItemExpanded(item)
                    } else {
                        ScoreListItemCollapsed(item) {
                            expandedItemIndex.value = index
                        }
                    }
                    Divider(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
                }
            }
        }
    }
}

@Composable
fun ScoreListItemCollapsed(item: ResultEntity, onClick: () -> Unit) {
    Row(Modifier.clickable { onClick() }) {
        Text(
            text = "Όνομα: ${item.name}",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Επίθετο: ${item.surname}", style = MaterialTheme.typography.body1)
    }
}

@Composable
fun ScoreListItemExpanded(item: ResultEntity) {
    Column {
        ScoreListItemCollapsed(item) {}
        Text(text = "School: ${item.school}", style = MaterialTheme.typography.body1)
        Text(text = "Correct: ${item.correct}", style = MaterialTheme.typography.body1)
        Text(text = "Incorrect: ${item.incorrect}", style = MaterialTheme.typography.body1)
        Text(text = "Time: ${item.time}", style = MaterialTheme.typography.body1)
    }
}
