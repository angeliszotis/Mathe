package com.example.mathapp.ui.home.composable.ButtonItem

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.mathapp.data.nav_data.HomeButtonsDC
import com.example.mathapp.data.nav_data.HomeButtonsDCVector
import com.example.mathapp.ui.home.HomeViewModel
import com.example.mathapp.ui.theme.FbColor

@Composable
fun ButtonItem(modifier: Modifier, item: HomeButtonsDC, viewModel: HomeViewModel) {


    Button(
        onClick = { viewModel.onItemClicked(item.action) },
        modifier = modifier,
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        colors = ButtonDefaults.buttonColors(FbColor)
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = "Localized description",
            modifier = Modifier.size(item.iconSize.dp),

            )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            item.text,
            fontSize = item.textSize.em
        )
    }
    Spacer(modifier = Modifier.height(16.dp))

}

@Composable
fun ButtonItem(modifier: Modifier, item: HomeButtonsDCVector, viewModel: HomeViewModel) {


    Button(
        onClick = { viewModel.onItemClicked(item.action) },

        modifier = modifier,
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        colors = ButtonDefaults.buttonColors(FbColor)
    ) {
        Icon(
            item.icon,
            contentDescription = "Localized description",
            modifier = Modifier.size(item.iconSize.dp),

            )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            item.text,
            fontSize = item.textSize.em
        )
    }
    Spacer(modifier = Modifier.height(16.dp))

}
