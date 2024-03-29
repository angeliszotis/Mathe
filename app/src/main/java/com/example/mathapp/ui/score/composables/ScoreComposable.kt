package com.example.mathapp.ui.score.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mathapp.R
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingDefault_16dp
import com.example.mathapp.util.BASE_URL_LOTTIE_SCORE_lf20_END
import com.example.mathapp.util.BASE_URL_LOTTIE_SCORE_lf20_MIDDLE
import com.example.mathapp.util.BASE_URL_LOTTIE_SCORE_lf20_START
import com.example.mathapp.util.NavScoreItems

@Composable
fun ScoreScreen( navController: NavController) {
    val lottieStart by rememberLottieComposition(LottieCompositionSpec.Url(url = BASE_URL_LOTTIE_SCORE_lf20_START))
    val lottieMiddle by rememberLottieComposition(LottieCompositionSpec.Url(url = BASE_URL_LOTTIE_SCORE_lf20_MIDDLE))
    val lottieEnd by rememberLottieComposition(LottieCompositionSpec.Url(url = BASE_URL_LOTTIE_SCORE_lf20_END))

    Column(modifier = Modifier.fillMaxSize().background(BabyBluePurple3).padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,) {
            Text(
                maxLines = 1,
                text = stringResource(id = R.string.score),
                color = BabyBluePurple5,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displayLarge,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(start = SpacingDefault_16dp)
            )
        }
        LottieLoader(modifier = Modifier.fillMaxWidth().padding(SpacingDefault_16dp).fillMaxHeight(0.01f), link ="https://assets2.lottiefiles.com/packages/lf20_vthcplog.json")
        Row(modifier = Modifier.fillMaxWidth().padding(SpacingDefault_16dp), horizontalArrangement = Arrangement.End) {
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = { navController.navigate(NavScoreItems.ScoreInternalUnit.destination) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = FbColor
                ),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(color = Color.White, text = stringResource(id = R.string.score_internal))
            }
            LottieAnimation(
                composition = lottieStart,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.aspectRatio(1f).weight(0.5f),
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth().padding(SpacingDefault_16dp),
            horizontalArrangement = Arrangement.Start
        ) {
            LottieAnimation(
                composition = lottieMiddle,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.aspectRatio(1f).weight(0.5f),
            )
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = { navController.navigate(NavScoreItems.ScoreExternalUnit.destination) },
                modifier = Modifier.weight(0.5f).padding(6.dp).aspectRatio(1f),
                colors = ButtonDefaults.buttonColors(backgroundColor = FbColor),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(color = Color.White, text = stringResource(id = R.string.score_external))
            }
        }


        Row(
            modifier = Modifier.fillMaxWidth().padding(SpacingDefault_16dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = { navController.navigate(NavScoreItems.ScoreAchievement.destination) },
                modifier = Modifier.weight(0.5f).padding(6.dp).aspectRatio(1f),
                colors = ButtonDefaults.buttonColors(backgroundColor = FbColor),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(color = Color.White, text = stringResource(id = R.string.score_achievement))
            }
            LottieAnimation(
                composition = lottieEnd,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.aspectRatio(1f).weight(0.5f),)
        }
    }
}