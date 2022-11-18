package com.example.mathapp.data.nav_data

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDirections
import com.example.mathapp.ui.home.HomeFragmentDirections

sealed class NavButtonItems(val destination: NavDirections) {
    object theory : NavButtonItems(HomeFragmentDirections.actionHomeToTheory())
    object profile : NavButtonItems(HomeFragmentDirections.actionHomeToProfile())
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