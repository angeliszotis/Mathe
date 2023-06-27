package com.example.mathapp.ui.dashboard.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.mathapp.R
import com.example.mathapp.ui.composable.ButtonItem.ButtonItem
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.dashboard.LobbyViewModel
import com.example.mathapp.ui.theme.*
import com.example.mathapp.util.HomeButtonsDC
import com.example.mathapp.util.HomeButtonsDCVector
import com.example.mathapp.util.NavButtonItems


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen(viewModel: LobbyViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BabyBluePurple2)
            .padding(horizontal = SpacingDefault_16dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                maxLines = 1,
                text = stringResource(id = R.string.app_name),
                color = BabyBluePurple5,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displayLarge,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(vertical = SpacingCustom_28dp, horizontal = SpacingDefault_16dp)
            )
            //NetworkState()
        }
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDC(
                text = stringResource(id = R.string.theory),
                textSize = 8,
                R.drawable.ic_baseline_menu_book_24,
                iconSize = 30,
                NavButtonItems.Theory
            ), viewModel
        )
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector(text = stringResource(id = R.string.exam), textSize = 8, Icons.Filled.Create, iconSize = 30,action= NavButtonItems.Exam),
            viewModel
        )
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector(text = stringResource(id = R.string.score), textSize = 8, icon=Icons.Filled.Star, iconSize = 30, action = NavButtonItems.Score), viewModel
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                HomeButtonsDCVector(
                    text =  stringResource(id = R.string.profile),
                    textSize = 3,
                    Icons.Filled.Person,
                    iconSize = 20,
                    NavButtonItems.Profile
                ), viewModel
            )
            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                HomeButtonsDCVector(
                    text = stringResource(id = R.string.info),
                    textSize = 3,
                    Icons.Filled.Info,
                    iconSize = 20,
                    NavButtonItems.Info
                ), viewModel
            )
        }
        LottieLoader()
    }
}