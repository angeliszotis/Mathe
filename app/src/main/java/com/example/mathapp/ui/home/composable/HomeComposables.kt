package com.example.mathapp.ui.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.mathapp.R
import com.example.mathapp.data.nav_data.HomeButtonsDC
import com.example.mathapp.data.nav_data.HomeButtonsDCVector
import com.example.mathapp.data.nav_data.NavButtonItems
import com.example.mathapp.ui.home.HomeViewModel
import com.example.mathapp.ui.composable.ButtonItem.ButtonItem
import com.example.mathapp.ui.composable.LottieLoader.Loader
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple5


@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple2)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(

            maxLines = 1,
            text = "Math App",
            textAlign = TextAlign.Center,
            color = BabyBluePurple5,
            fontWeight = FontWeight.Bold,
            fontSize = 17.em,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.padding(28.dp)
        )

        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDC(
                "Θεωρία",
                8,
                R.drawable.ic_baseline_menu_book_24,
                30,
                NavButtonItems.theory
            ), viewModel
        )
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector("Εξέταση", 8, Icons.Filled.Create, 30, NavButtonItems.exam),
            viewModel
        )
        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector("Σκορ", 8, Icons.Filled.Star, 30, NavButtonItems.theory), viewModel
        )




        Row(modifier = Modifier.fillMaxWidth()) {

            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(6.dp),
                HomeButtonsDCVector(
                    "Προφίλ",
                    3,
                    Icons.Filled.Person,
                    20,
                    NavButtonItems.profile
                ), viewModel
            )
            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(6.dp),
                HomeButtonsDCVector(
                    "Πληροφορίες",
                    3,
                    Icons.Filled.Info,
                    20,
                    NavButtonItems.theory
                ), viewModel
            )
        }

        Loader()
    }
}





