package com.example.mathapp.ui.score.achievement.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.framework.achievment.model.AchievementModel
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.score.achievement.AchievementViewModel
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.SpacingHalf_8dp

@Composable
fun AchievementScreen(viewModel: AchievementViewModel, achievements: List<AchievementModel>) {
    var lastEntryPoints = viewModel.internalScore.observeAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BabyBluePurple3),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(achievements) { item ->
            viewModel.getScoreInternal(item.unit)
            when(item.unit){
                1-> lastEntryPoints = viewModel.internalScore.observeAsState()
                2-> lastEntryPoints = viewModel.internalScore2.observeAsState()
                3-> lastEntryPoints = viewModel.internalScore3.observeAsState()
                4-> lastEntryPoints = viewModel.internalScore4.observeAsState()
                5-> lastEntryPoints = viewModel.internalScore5.observeAsState()
                6-> lastEntryPoints = viewModel.internalScore6.observeAsState()
                7-> lastEntryPoints = viewModel.internalScore7.observeAsState()
                8-> lastEntryPoints = viewModel.internalScore8.observeAsState()
            }
            val lastEntryPoint = lastEntryPoints.value?.lastOrNull()

            val points = lastEntryPoint?.point?.toIntOrNull() ?: 0

            if (points >= 2) {
                AchievementItem(item)
                Spacer(modifier = Modifier.height(16.dp))

            } else {
                AchievementUnlockItem(item.unit.toString()) // Add the unit to the unlockItems list
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    // Show unlock items for units with points less than 10

}
@Composable
fun AchievementItem(achievement: AchievementModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth() ,
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        backgroundColor = BabyBluePurple2
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(achievement.img), contentDescription = null, modifier = Modifier
                .size(120.dp)
                .clip(shape = CircleShape))

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = stringResource(id = achievement.title), style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp), modifier = Modifier.padding(top = 8.dp))

            Text(text = "("+stringResource(id = achievement.date)+")", modifier = Modifier.padding(top = 4.dp))

            Text(text = stringResource(id = achievement.info), modifier = Modifier.padding(top = SpacingHalf_8dp))
        }
    }
}

@Composable
fun AchievementUnlockItem(unit:String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle item click */ },
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        backgroundColor = BabyBluePurple2
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            LottieLoader(modifier = Modifier
                .size(120.dp)
                .clip(shape = CircleShape), link = "https://lottie.host/72abe0e2-8af4-4ad4-88c9-e2e595efe6d7/fXNzual3kf.json")
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Για να ξεκληδωσεις πρεπει να μαζεψεις 10 ποντους απο την ενοτητα $unit", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp), modifier = Modifier.padding(top = 8.dp))
            
        }
    }
}

