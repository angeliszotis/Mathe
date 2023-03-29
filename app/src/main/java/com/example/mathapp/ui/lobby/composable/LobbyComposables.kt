package com.example.mathapp.ui.lobby.composable

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
import com.example.mathapp.data.nav_data.HomeButtonsDC
import com.example.mathapp.data.nav_data.HomeButtonsDCVector
import com.example.mathapp.data.nav_data.NavButtonItems
import com.example.mathapp.ui.composable.ButtonItem.ButtonItem
import com.example.mathapp.ui.composable.LottieLoader.Loader
import com.example.mathapp.ui.lobby.LobbyViewModel
import com.example.mathapp.ui.theme.*


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
        }
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDC(
                text = "Θεωρία",
                textSize = 8,
                R.drawable.ic_baseline_menu_book_24,
                iconSize = 30,
                NavButtonItems.theory
            ), viewModel
        )
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector(text = "Εξέταση", textSize = 8, Icons.Filled.Create, iconSize = 30, NavButtonItems.exam),
            viewModel
        )
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector(text = "Σκορ", textSize = 8, Icons.Filled.Star, iconSize = 30, NavButtonItems.theory), viewModel
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                HomeButtonsDCVector(
                    text = "Προφίλ",
                    textSize = 3,
                    Icons.Filled.Person,
                    iconSize = 20,
                    NavButtonItems.profile
                ), viewModel
            )
            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                HomeButtonsDCVector(
                    text = "Πληροφορίες",
                    textSize = 3,
                    Icons.Filled.Info,
                    iconSize = 20,
                    NavButtonItems.info
                ), viewModel
            )
        }
        Loader()
    }
}





