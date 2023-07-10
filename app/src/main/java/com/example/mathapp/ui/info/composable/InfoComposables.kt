package com.example.mathapp.ui.info.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    // Dialog state for each button
    val theoryDialogBool = remember { mutableStateOf(false) }
    val examDialogBool = remember { mutableStateOf(false) }
    val scoreDialogBool = remember { mutableStateOf(false) }
    val profileDialogBool = remember { mutableStateOf(false) }

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
                onClick = {theoryDialogBool.value = true},
                modifier = Modifier.weight(0.5f),
                icon = R.drawable.ic_baseline_menu_book_24
            )
            RoundedButton(text = stringResource(id = R.string.exam), onClick = {examDialogBool.value = true}, modifier = Modifier.weight(0.5f), vector = Icons.Filled.Create)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            RoundedButton(text = stringResource(id = R.string.score), onClick = {scoreDialogBool.value = true}, modifier = Modifier.weight(0.5f).fillMaxWidth(), vector = Icons.Filled.Star)
            RoundedButton(text = stringResource(id = R.string.profile), onClick = {profileDialogBool.value = true}, modifier = Modifier.weight(0.5f).fillMaxWidth(), vector = Icons.Filled.Person)
        }
        // Dialog 1
        if (theoryDialogBool.value) {
            InfoTheoryDialog(onDismiss = { theoryDialogBool.value = false })
        }

        // Dialog 2
        if (examDialogBool.value) {
            InfoExamDialog(onDismiss = { examDialogBool.value= false })
        }

        // Dialog 3
        if (scoreDialogBool.value) {
            InfoScoreDialog(onDismiss = { scoreDialogBool.value = false })
        }

        // Dialog 4
        if (profileDialogBool.value) {
            InfoProfileDialog(onDismiss = { profileDialogBool.value = false })
        }

        LottieLoader(link = "https://assets7.lottiefiles.com/packages/lf20_2KPsjeiBYB.json")
    }
}

@Composable
fun InfoTheoryDialog(onDismiss: () -> Unit) {
    // Dialog 1 content
    AlertDialog(
        backgroundColor = BabyBluePurple2,
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(SpacingDefault_16dp),
        title = {
            Text(text = stringResource(id = R.string.theory))
        },
        text = {
            Column(Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.info_theory_start_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_theory_end_dialog))
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth().padding(SpacingHalf_8dp),
                contentAlignment = Alignment.Center
            ) {
                RoundedButton(
                    onClick = { onDismiss() },
                    text = stringResource(id = R.string.info_ok_dialog)
                )
            }
        }
    )
}

@Composable
fun InfoExamDialog(onDismiss: () -> Unit) {
    // Dialog 2 content
    AlertDialog(
        backgroundColor = BabyBluePurple2,
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(SpacingDefault_16dp),
        title = {
            Text(text = stringResource(id = R.string.exam))
        },
        text = {
            Column(Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.info_exam_start_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_exam_mid_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_theory_end_dialog))
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth().padding(SpacingHalf_8dp),
                contentAlignment = Alignment.Center
            ) {
                RoundedButton(
                    onClick = { onDismiss() },
                    text = stringResource(id = R.string.info_ok_dialog)
                )
            }
        }
    )
}
@Composable
fun InfoScoreDialog(onDismiss: () -> Unit) {
    // Dialog 2 content
    AlertDialog(
        backgroundColor = BabyBluePurple2,
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(SpacingDefault_16dp),
        title = {
            Text(text = stringResource(id = R.string.score))
        },
        text = {
            Column(Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.info_score_start_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_score_mid_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_score_end_dialog))
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth().padding(SpacingHalf_8dp),
                contentAlignment = Alignment.Center
            ) {
                RoundedButton(
                    onClick = { onDismiss() },
                    text = stringResource(id = R.string.info_ok_dialog)
                )
            }
        }
    )
}
@Composable
fun InfoProfileDialog(onDismiss: () -> Unit) {
    // Dialog 2 content
    AlertDialog(
        backgroundColor = BabyBluePurple2,
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(SpacingDefault_16dp),
        title = {
            Text(text = stringResource(id = R.string.profile))
        },
        text = {
            Column(Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.info_profile_start_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_profile_mid_dialog))
                Spacer(modifier = Modifier.height(SpacingHalf_8dp))
                Text(text = stringResource(id = R.string.info_profile_end_dialog))
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth().padding(SpacingHalf_8dp),
                contentAlignment = Alignment.Center
            ) {
                RoundedButton(
                    onClick = { onDismiss() },
                    text = stringResource(id = R.string.info_ok_dialog)
                )
            }
        }
    )
}
