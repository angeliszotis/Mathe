package com.example.mathapp.ui.score.achievement.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mathapp.R
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.SpacingQuadruple_64dp

@Composable
fun AchievementScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = BabyBluePurple3) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp).background(BabyBluePurple2, RoundedCornerShape(SpacingQuadruple_64dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AchievementTitle(title = "Achievement Unlocked")
            ProfileImage()
            Spacer(modifier = Modifier.height(16.dp))
            BiographyText()
        }
    }
}

@Composable
fun AchievementTitle(title: String) {
    Text(text = title, style = MaterialTheme.typography.h5, color = MaterialTheme.colors.onBackground, textAlign = TextAlign.Start)
}

@Composable
fun ProfileImage() {
    Image(painter = painterResource(R.drawable.baseline_call_24), contentDescription = "Profile Image", modifier = Modifier.size(200.dp))
}

@Composable
fun BiographyText() {
    Text(text = "Biography of the person goes here...", style = MaterialTheme.typography.body1, color = MaterialTheme.colors.onBackground, textAlign = TextAlign.Center)
}