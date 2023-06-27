package com.example.mathapp.ui.unit.composable

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.mathapp.R
import com.example.mathapp.framework.theory.model.UnitModel
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.theme.BabyBluePurple1
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.util.BASE_URL_LOTTIE_THEORY_lf20_START
import com.example.mathapp.util.units


@Composable
fun UnitScreen() {
    UnitContent(units = units, buttonTextSize = 4.em, buttonColor = FbColor)
}

@Composable
fun UnitContent(
    units: List<UnitModel>,
    buttonTextSize: TextUnit = 4.em,
    buttonColor: Color = FbColor
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier) {
            Spacer(modifier = Modifier.size(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    maxLines = 1,
                    text = stringResource(id = R.string.chose_unit),
                    textAlign = TextAlign.Center,
                    color = BabyBluePurple1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 7.em,
                    fontFamily = FontFamily.Monospace
                )
            }
            LottieLoader(link = BASE_URL_LOTTIE_THEORY_lf20_START)
        }

        for (unit in units.chunked(2)) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (data in unit) {
                    Button(
                        onClick = {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(data.url)
                                )
                            )
                        },
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(6.dp)
                            .aspectRatio(1f),
                        contentPadding = ButtonDefaults.TextButtonContentPadding,
                        colors = ButtonDefaults.buttonColors(buttonColor)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                            contentDescription = "Book icon",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text(
                            maxLines = 1,
                            text = stringResource(id = data.nameResourceId),
                            fontSize = buttonTextSize
                        )
                    }
                }
            }
        }
    }
}