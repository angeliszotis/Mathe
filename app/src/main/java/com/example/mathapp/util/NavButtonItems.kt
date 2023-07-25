package com.example.mathapp.util

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDirections
import com.example.mathapp.ui.dashboard.LobbyFragmentDirections
import com.example.mathapp.ui.exam.ExamFragmentDirections
import com.example.mathapp.ui.score.ScoreFragmentDirections
import com.example.mathapp.ui.unit.UnitFragmentDirections


sealed class NavButtonItems(val destination: NavDirections) {
    object Theory : NavButtonItems(LobbyFragmentDirections.actionFragmentHomeToFragmentTheory())
    object Profile : NavButtonItems(LobbyFragmentDirections.actionHomeToProfile())
    object Exam : NavButtonItems(LobbyFragmentDirections.actionFragmentHomeToFragmentExam())
    object Info : NavButtonItems(LobbyFragmentDirections.actionHomeToInfo())
    object Score : NavButtonItems(LobbyFragmentDirections.actionHomeToScore())
    object Chat : NavButtonItems(LobbyFragmentDirections.actionFragmentHomeToFragmentChat())
}

sealed class NavExamItems(val destination: NavDirections){
    object UnitOne : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(1))
    object UnitTwo : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(2))
    object UnitThree : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(3))
    object UnitFour : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(4))
    object UnitFive : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(5))
    object UnitSix : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(6))
    object UnitSeven : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(7))
    object UnitEight : NavExamItems(ExamFragmentDirections.actionFragmentExamToFragmentQuiz(8))

}
sealed class NavScoreInternal(val destination: NavDirections){
    object UnitOne : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(1) )
    object UnitTwo : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(2))
    object UnitThree : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(3))
    object UnitFour : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(4))
    object UnitFive : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(5))
    object UnitSix : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(6))
    object UnitSeven : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(7))
    object UnitEight : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreInternal2(8))

}
sealed class NavScoreExternal(val destination: NavDirections){
    object UnitOne : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(1))
    object UnitTwo : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(2))
    object UnitThree : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(3))
    object UnitFour : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(4))
    object UnitFive : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(5))
    object UnitSix : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(6))
    object UnitSeven : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(7))
    object UnitEight : NavExamItems(UnitFragmentDirections.actionFragmentUnitToFragmentScoreExternal2(8))
}
sealed class NavScoreItems(val destination: NavDirections){
    object ScoreInternalUnit : NavScoreItems(ScoreFragmentDirections.actionFragmentScoreToFragmentUnit(true,true))
    object ScoreExternalUnit : NavScoreItems(ScoreFragmentDirections.actionFragmentScoreToFragmentUnit(true,false))
    object ScoreAchievement: NavScoreItems(ScoreFragmentDirections.actionFragmentScoreToFragmentAchievement())
}

data class HomeButtonsDC(val text: String?, val textSize: Int, val icon: Int, val iconSize: Int, val action: NavButtonItems)

data class HomeButtonsDCVector(val text: String?, val textSize: Int, val icon: ImageVector, val iconSize: Int, val action: NavButtonItems)