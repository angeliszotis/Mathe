package com.example.mathapp.ui.score.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mathapp.ui.score.ScoreViewModel
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.util.NavButtonItems

@Composable
fun ScoreScreen(viewModel: ScoreViewModel, navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://assets4.lottiefiles.com/packages/lf20_bq0iyadj.json"))
    val composition2 by rememberLottieComposition(LottieCompositionSpec.Url("https://assets3.lottiefiles.com/packages/lf20_si7bhkv8.json"))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(16.dp),
    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { navController.navigate(NavButtonItems.ScoreInternal.destination) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = FbColor
                ),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(color = Color.White, text = "Τοπίκα Σκορ")
            }
            LottieAnimation(
                    composition = composition,
            iterations = LottieConstants.IterateForever,
            clipSpec = LottieClipSpec.Progress(0.1f, 0.70f),
            modifier = Modifier.aspectRatio(1f).weight(0.5f),
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            LottieAnimation(
                composition = composition2,
                iterations = LottieConstants.IterateForever,
                clipSpec = LottieClipSpec.Progress(0.1f, 0.70f),
                modifier = Modifier.aspectRatio(1f).weight(0.5f),
            )
            Button(
                onClick = { navController.navigate(NavButtonItems.ScoreExternal.destination) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = FbColor
                ),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(color = Color.White,text = "Δημόσια Σκορ")
            }
        }
    }
}

@Composable
fun Loader2(link: String) {


}