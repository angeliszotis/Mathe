package com.example.mathapp.ui.info.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.ui.composable.ButtonItem.RoundedButton
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5
import com.example.mathapp.ui.theme.SpacingCustom_10dp
import com.example.mathapp.ui.theme.SpacingDefault_16dp
import com.example.mathapp.ui.theme.SpacingHalf_8dp

@Composable
fun InfoScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .verticalScroll(rememberScrollState())
        .padding(horizontal = SpacingDefault_16dp, vertical = SpacingCustom_10dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = stringResource(id = R.string.info),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            color = BabyBluePurple5,
            fontFamily = FontFamily.Cursive,
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpacingHalf_8dp),
            backgroundColor = BabyBluePurple2,
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp),
            ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.info_welcome),
                    style = MaterialTheme.typography.body1,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.info_welcome_start),
                    style = MaterialTheme.typography.body1, fontSize = 14.sp, modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = stringResource(id = R.string.info_version),
                    style = MaterialTheme.typography.body1,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.info_developer),
                    style = MaterialTheme.typography.body1,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.info_contact),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            RoundedButton(
                text = stringResource(id = R.string.theory),
                onClick = {},
                modifier = Modifier.weight(0.5f),
                icon = R.drawable.ic_baseline_menu_book_24
            )
            RoundedButton(text = stringResource(id = R.string.exam), onClick = {}, modifier = Modifier.weight(0.5f), vector = Icons.Filled.Create)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            RoundedButton(text = stringResource(id = R.string.score), onClick = {}, modifier = Modifier.weight(0.5f), vector = Icons.Filled.Star)
            RoundedButton(text = stringResource(id = R.string.profile), onClick = {}, modifier = Modifier.weight(0.5f), vector = Icons.Filled.Person)
        }
        LottieLoader(link = "https://assets7.lottiefiles.com/packages/lf20_2KPsjeiBYB.json")
    }
}

