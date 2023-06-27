package com.example.mathapp.ui.composable.LottieLoader

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieLoader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://assets5.lottiefiles.com/packages/lf20_YrdJ2K8cQY.json"))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever, modifier = Modifier.aspectRatio(1f)
    )
}

@Composable
fun LottieLoader(link: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url(link))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        clipSpec = LottieClipSpec.Progress(0.1f, 0.70f),
        modifier = Modifier.aspectRatio(1f),
    )
}