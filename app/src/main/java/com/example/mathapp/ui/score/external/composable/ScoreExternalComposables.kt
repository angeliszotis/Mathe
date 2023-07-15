package com.example.mathapp.ui.score.external.composable

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mathapp.R
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.ui.score.ScoreViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3

@Composable
fun ScoreExternalScreen(viewModel: ScoreViewModel) {

    val scoreList by viewModel.externalScore.observeAsState()
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
                .background(BabyBluePurple2, RoundedCornerShape(bottomEnd = 80.dp, topStart = 80.dp, topEnd = 20.dp, bottomStart = 20.dp))
                .clip(RectangleShape)
                .padding(vertical = 25.dp), verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    modifier = Modifier.padding(bottom = 24.dp) ,
                    text = stringResource(id = R.string.score_external) +" "+ stringResource(id = R.string.score),
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
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
fun ScoreListItemCollapsed(item: ResultModel, onClick: () -> Unit) {
    Row(Modifier.clickable { onClick() }) {
        Text(text =  stringResource(id = R.string.score_name, item.name), style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(id = R.string.score_surname, item.surname), style = MaterialTheme.typography.body1)
    }
}

@Composable
fun ScoreListItemExpanded(item: ResultModel) {
    Column {
        ScoreListItemCollapsed(item) {}
        Text(text = stringResource(id = R.string.score_school, item.school), style = MaterialTheme.typography.body1)
        Text(text = stringResource(id = R.string.score_correct, item.correct), style = MaterialTheme.typography.body1)
        Text(text = stringResource(id = R.string.score_incorrect, item.incorrect), style = MaterialTheme.typography.body1)
        Text(text = stringResource(id = R.string.score_time, item.time), style = MaterialTheme.typography.body1)
    }
}