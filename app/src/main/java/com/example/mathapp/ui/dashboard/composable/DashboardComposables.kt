package com.example.mathapp.ui.dashboard.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.mathapp.R
import com.example.mathapp.ui.composable.ButtonItem.ButtonItem
import com.example.mathapp.ui.composable.LottieLoader.LottieLoader
import com.example.mathapp.ui.dashboard.LobbyViewModel
import com.example.mathapp.ui.theme.*
import com.example.mathapp.util.BASE_URL_LOTTIE_DASHBOARD_lf20_END
import com.example.mathapp.util.HomeButtonsDC
import com.example.mathapp.util.HomeButtonsDCVector
import com.example.mathapp.util.NavButtonItems
import com.example.mathapp.util.SettingsManager
import com.example.mathapp.util.showToast


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HomeScreen(viewModel: LobbyViewModel) {
    val musicEnabled = remember { mutableStateOf(SettingsManager.isMusicEnabled()) }
    val examBoolean by viewModel.dashboardGetExamBool().collectAsState(initial = false)
    val context = LocalContext.current
    val switchText = if (musicEnabled.value) { R.string.dashboard_music_enable_text} else { R.string.dashboard_music_disable_text }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BabyBluePurple2)
            .padding(horizontal = SpacingCustom_20dp),
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
                modifier = Modifier.padding(SpacingDefault_16dp)
            )
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
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (!examBoolean) {
                    viewModel.onItemClicked(NavButtonItems.Exam)
                } else {
                    showToast(context = context, message = R.string.dashboard_exam_toast)
                }
            },
            contentPadding = ButtonDefaults.TextButtonContentPadding,
            colors = ButtonDefaults.buttonColors(FbColor)
        ) {
            Icon(
                imageVector = Icons.Filled.Create,
                contentDescription = "Localized description",
                modifier = Modifier.size(30.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(stringResource(id = R.string.exam), fontSize = 8.em)
        }
        Spacer(modifier = Modifier.height(16.dp))

        ButtonItem(
            Modifier.fillMaxWidth(),
            HomeButtonsDCVector(
                text = stringResource(id = R.string.score),
                textSize = 8,
                icon = Icons.Filled.Star,
                iconSize = 30,
                action = NavButtonItems.Score
            ), viewModel
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonItem(
                Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                HomeButtonsDCVector(
                    text = stringResource(id = R.string.profile),
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
            ButtonItem(
                Modifier.weight(0.5f).padding(SpacingCustom_6dp),
                HomeButtonsDCVector(
                    text = null,
                    textSize = 3,
                    icon = Icons.Filled.Email,
                    iconSize = 20,
                    action= NavButtonItems.Chat
                ), viewModel
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Text(
                text = stringResource(id = switchText),
                color = BabyBluePurple5,
                fontWeight = FontWeight.Bold,
                style = androidx.compose.material.MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f),
                fontSize = 10.sp
            )
            Switch(
                checked = musicEnabled.value,
                onCheckedChange = { isChecked ->
                    musicEnabled.value = isChecked
                    SettingsManager.setMusicEnabled(isChecked)
                },
            )
        }
        LottieLoader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), link = BASE_URL_LOTTIE_DASHBOARD_lf20_END
        )
    }
}