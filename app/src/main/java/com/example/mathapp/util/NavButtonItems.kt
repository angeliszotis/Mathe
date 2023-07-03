package com.example.mathapp.util

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDirections
import com.example.mathapp.ui.dashboard.LobbyFragmentDirections
import com.example.mathapp.ui.exam.ExamFragmentDirections
import com.example.mathapp.ui.score.ScoreFragmentDirections


sealed class NavButtonItems(val destination: NavDirections) {
    object Theory : NavButtonItems(LobbyFragmentDirections.actionFragmentHomeToFragmentTheory())
    object Profile : NavButtonItems(LobbyFragmentDirections.actionHomeToProfile())
    object Exam : NavButtonItems(LobbyFragmentDirections.actionFragmentHomeToFragmentExam())
    object Info : NavButtonItems(LobbyFragmentDirections.actionHomeToInfo())
    object Score : NavButtonItems(LobbyFragmentDirections.actionHomeToScore())
    object ScoreInternal :
        NavButtonItems(ScoreFragmentDirections.actionFragmentScoreToFragmentScoreInternal())
    object ScoreExternal :
        NavButtonItems(ScoreFragmentDirections.actionFragmentScoreToFragmentScoreExternal())
}

sealed class NavExamItems(val destination: NavDirections){
    object UnitOne : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz())
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