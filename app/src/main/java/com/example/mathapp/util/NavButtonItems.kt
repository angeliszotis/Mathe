package com.example.mathapp.util

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDirections
import com.example.mathapp.ui.dashboard.LobbyFragmentDirections
import com.example.mathapp.ui.score.ScoreFragmentDirections

sealed class NavButtonItems(val destination: NavDirections) {
    object Theory : NavButtonItems(LobbyFragmentDirections.actionHomeToTheory())
    object Profile : NavButtonItems(LobbyFragmentDirections.actionHomeToProfile())
    object Exam : NavButtonItems(LobbyFragmentDirections.actionHomeToExam())
    object Info : NavButtonItems(LobbyFragmentDirections.actionHomeToInfo())
    object Score : NavButtonItems(LobbyFragmentDirections.actionHomeToScore())
    object ScoreInternal :
        NavButtonItems(ScoreFragmentDirections.actionFragmentScoreToFragmentScoreInternal())

    object ScoreExternal :
        NavButtonItems(ScoreFragmentDirections.actionFragmentScoreToFragmentScoreExternal())

}

data class HomeButtonsDC(
    val text: String,
    val textSize: Int,
    val icon: Int,
    val iconSize: Int,
    val action: NavButtonItems
)

data class HomeButtonsDCVector(
    val text: String,
    val textSize: Int,
    val icon: ImageVector,
    val iconSize: Int,
    val action: NavButtonItems
)