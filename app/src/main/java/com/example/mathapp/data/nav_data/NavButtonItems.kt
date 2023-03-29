package com.example.mathapp.data.nav_data

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDirections
import com.example.mathapp.ui.lobby.LobbyFragmentDirections

sealed class NavButtonItems(val destination: NavDirections) {
    object theory : NavButtonItems(LobbyFragmentDirections.actionHomeToTheory())
    object profile : NavButtonItems(LobbyFragmentDirections.actionHomeToProfile())
    object exam : NavButtonItems(LobbyFragmentDirections.actionHomeToExam())
    object info : NavButtonItems(LobbyFragmentDirections.actionHomeToInfo())
    object score : NavButtonItems(LobbyFragmentDirections.actionHomeToScore())

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