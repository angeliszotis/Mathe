package com.example.mathapp.ui.profile.composable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mathapp.data.room.entity.UserEntity
import com.example.mathapp.ui.profile.ProfileViewModel
import com.example.mathapp.ui.profile.setUDM
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3


@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {

    var dt = viewModel.readAllData.observeAsState(listOf()).value
    var list: List<UserEntity> = listOf()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (dt == emptyList<UserEntity>()) {
            TextFieldsForProfile(viewModel, textName = "", textSurname = "", textSchool = "")

        } else {
            list = dt

            var num: Int = if (list[0].name.equals("")) {
                list.size - 1
            } else {
                list.size - 2
            }
            Log.d("yoda", list.toString())
            var textName by remember { mutableStateOf(TextFieldValue(list[num].name.toString())) }
            var textSurname by remember { mutableStateOf(TextFieldValue(list[num].surname.toString())) }
            var textSchool by remember { mutableStateOf(TextFieldValue(list[num].school.toString())) }

            TextFieldsForProfile(
                viewModel,
                textName = textName.text,
                textSurname = textSurname.text,
                textSchool = textSchool.text
            )
        }
    }
}

@Composable
fun Loader(link: String, clip: Boolean) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url(link))

    if (clip) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            clipSpec = LottieClipSpec.Progress(0f, 1f),
            modifier = Modifier.aspectRatio(1f),
            speed = 0.7f
        )
    } else {
        LottieAnimation(
            composition = composition,
            clipSpec = LottieClipSpec.Progress(0f, 1f),

            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),
        )
    }
}

@Composable
fun TextFieldsForProfile(
    viewModel: ProfileViewModel,
    textName: String,
    textSurname: String,
    textSchool: String
) {

    var textName by remember { mutableStateOf(TextFieldValue(textName)) }
    var textSurname by remember { mutableStateOf(TextFieldValue(textSurname)) }
    var textSchool by remember { mutableStateOf(TextFieldValue(textSchool)) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 80.dp,
                    topStart = 80.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp
                )
            )
    )
    {
        Loader("https://assets10.lottiefiles.com/packages/lf20_n1wgeaxb.json", false)
        Text(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .weight(0.5f)
                .padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 5.em,
            text = " ${textName.text} ${textSurname.text}",
            maxLines = 2,
        )


    }
    Column(
        modifier = Modifier
            .padding(vertical = 25.dp)
            .fillMaxWidth()
            .background(
                BabyBluePurple2,
                RoundedCornerShape(
                    bottomEnd = 80.dp,
                    topStart = 80.dp,
                    topEnd = 20.dp,
                    bottomStart = 20.dp
                )
            )
            .clip(RectangleShape), verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(30.dp))

        OutlinedTextField(
            value = textName,
            label = { Text("Όνομα", fontWeight = FontWeight.Bold) },
            onValueChange = {
                textName = it

            })
        Spacer(modifier = Modifier.size(15.dp))
        OutlinedTextField(
            value = textSurname,
            label = { Text("Επίθετο", fontWeight = FontWeight.Bold) },
            onValueChange = {
                textSurname = it

            })
        Spacer(modifier = Modifier.size(15.dp))

        OutlinedTextField(
            value = textSchool,
            label = { Text("Σχολείο", fontWeight = FontWeight.Bold) },
            onValueChange = {
                textSchool = it

            })
        Spacer(modifier = Modifier.size(30.dp))

        Button(
            modifier = Modifier.fillMaxWidth(0.5f),
            onClick = {
                setUDM(
                    viewModel = viewModel,
                    textName.text,
                    textSurname.text,
                    textSchool.text
                )
            }) {
            Text(text = "Αποθήκευση!")
        }

        Spacer(modifier = Modifier.size(30.dp))


        Loader("https://assets10.lottiefiles.com/packages/lf20_xyadoh9h.json", true)
    }

}





