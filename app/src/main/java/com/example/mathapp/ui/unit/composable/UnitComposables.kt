package com.example.mathapp.ui.unit.composable

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mathapp.R
import com.example.mathapp.framework.theory.model.UnitExamModel
import com.example.mathapp.framework.theory.model.UnitTheoryModel
import com.example.mathapp.ui.composable.ButtonItem.RoundedButton
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingCustom_10dp
import com.example.mathapp.ui.theme.SpacingDefault_16dp
import com.example.mathapp.util.BASE_URL_LOTTIE_THEORY_lf20_START
import com.example.mathapp.util.units
import com.example.mathapp.util.unitsExam
import com.example.mathapp.util.unitsExternalScore
import com.example.mathapp.util.unitsInternalScore


@Composable
fun UnitScreen(navController: NavController, exam : Boolean, score:Boolean, scoreInternal:Boolean) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(BabyBluePurple3)
        .padding(horizontal = 16.dp)
        .verticalScroll(rememberScrollState())) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.7f)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(0.5f),
                    maxLines = 2,
                    text = stringResource(id = R.string.chose_unit),
                    textAlign = TextAlign.Start,
                    color = BabyBluePurple5,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Cursive,
                    )
                LottieLoader(modifier = Modifier.weight(0.5f), link = BASE_URL_LOTTIE_THEORY_lf20_START)
            }
        Column( modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f), horizontalAlignment = Alignment.CenterHorizontally) {
            if (exam) { ExamUnits(navController = navController) }
            else if(score) { ScoreUnits(navController = navController, scoreInternal = scoreInternal) }
            else{ UnitContent(units = units, buttonColor = FbColor) }
        }
    }
}

@Composable
fun UnitContent(units: List<UnitTheoryModel>, buttonColor: Color = FbColor) {

    val context = LocalContext.current

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
                        fontSize = 4.em
                    )
                }
            }
        }
    }
}

@Composable
fun ExamUnits(navController: NavController) {

    for (unitRow in unitsExam.chunked(2)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            for (item in unitRow) {
                val selectedItem by remember { mutableStateOf<UnitExamModel?>(item) }
                item.nameResourceId?.let { stringResource(id = it) }?.let {
                    ConfirmationButton(
                        onConfirm = { if (selectedItem != null) { selectedItem!!.action?.let { it1 -> navController.navigate(it1.destination) } } },
                        modifier = Modifier
                            .padding(6.dp)
                            .weight(1f)
                            .aspectRatio(1f),
                        title = it,
                    )
                }

            }
        }
    }
}
@Composable
fun ConfirmationButton(onConfirm: () -> Unit?, modifier: Modifier = Modifier, title: String) {

    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            modifier= Modifier.verticalScroll(rememberScrollState()),
            containerColor = BabyBluePurple2,
            shape = RoundedCornerShape(SpacingDefault_16dp),
            onDismissRequest = { showDialog = false },
            title = { Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(textAlign = TextAlign.Center,text = stringResource(id = R.string.welcome_message)+"\n"+title )
            }
                    },
            text = {
                Column(modifier = Modifier
                    .padding(SpacingCustom_10dp)) {
                Text(
                    text = stringResource(id = R.string.quiz_description) ,
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = SpacingCustom_10dp)
                )
                Text(text = stringResource(id = R.string.quiz_results), fontSize = 12.sp, color = Color.Black, modifier = Modifier.padding(bottom = SpacingCustom_10dp))
                Text(text = stringResource(id = R.string.good_luck), fontSize = 12.sp, color = Color.Black)
            } },
            confirmButton = {
                RoundedButton(onClick = {
                    onConfirm()
                    showDialog = false },
                    text = stringResource(id = R.string.start))
            },
            dismissButton = { RoundedButton( onClick = { showDialog = false }, text = stringResource(id = R.string.cansel)) }
        )
    }
    Button(onClick = { showDialog = true }, modifier = modifier, contentPadding = ButtonDefaults.TextButtonContentPadding, colors = ButtonDefaults.buttonColors(FbColor)) {
        Icon(imageVector = Icons.Filled.Create, contentDescription = "pencil icon", modifier = Modifier.size(25.dp))
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(maxLines = 1, text = title, fontSize = 4.em)
    }
}

@Composable
fun ScoreUnits( navController: NavController,scoreInternal:Boolean) {

    val units = if (scoreInternal){ unitsInternalScore } else{ unitsExternalScore }

    for (unitRow in units.chunked(2)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            for (item in unitRow) {
                Button(
                    onClick = { navController.navigate( item.action) },
                    modifier = Modifier
                        .padding(6.dp)
                        .weight(1f)
                        .aspectRatio(1f),
                    contentPadding = ButtonDefaults.TextButtonContentPadding,
                    colors = ButtonDefaults.buttonColors(FbColor)
                ) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "star icon", modifier = Modifier.size(25.dp))
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(maxLines = 1, text = stringResource(id = item.nameResourceId), fontSize = 4.em)
                }
            }
        }
    }
}