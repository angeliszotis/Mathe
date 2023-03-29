package com.example.mathapp.ui.info.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.SpacingCustom_10dp
import com.example.mathapp.ui.theme.SpacingCustom_6dp

@Composable
fun InfoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(horizontal = SpacingCustom_6dp, vertical = SpacingCustom_10dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    }
}



