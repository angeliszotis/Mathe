package com.example.mathapp.ui.profile.composable

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mathapp.R
import com.example.mathapp.framework.users.model.UserEntity
import com.example.mathapp.ui.profile.ProfileViewModel
import com.example.mathapp.ui.profile.setUDM
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.SpacingCustom_6dp
import com.example.mathapp.util.BASE_URL_LOTTIE_PROFILE_lf20_END
import com.example.mathapp.util.BASE_URL_LOTTIE_PROFILE_lf20_START


@Composable
fun ProfileScreen(viewModel: ProfileViewModel, onGoBack: () -> Unit) {

    val dt = viewModel.readAllData.observeAsState(listOf()).value
    var list: List<UserEntity>

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
            TextFieldsForProfile(viewModel, textName = "", textSurname = "", textSchool = "",onGoBack = onGoBack)
        } else {
            list = dt

            val num: Int = if (list[0].name == "") {
                list.size - 1
            } else {
                list.size - 2
            }
            val textName by remember { mutableStateOf(TextFieldValue(list[num].name)) }
            val textSurname by remember { mutableStateOf(TextFieldValue(list[num].surname)) }
            val textSchool by remember { mutableStateOf(TextFieldValue(list[num].school)) }

            TextFieldsForProfile(
                viewModel,
                textName = textName.text,
                textSurname = textSurname.text,
                textSchool = textSchool.text,
                onGoBack = onGoBack
            )
        }
    }
}

@Composable
fun TextFieldsForProfile(
    viewModel: ProfileViewModel,
    textName: String,
    textSurname: String,
    textSchool: String,
    onGoBack: () -> Unit
) {

    val context = LocalContext.current

    var name by remember { mutableStateOf(TextFieldValue(textName)) }
    var surname by remember { mutableStateOf(TextFieldValue(textSurname)) }
    var school by remember { mutableStateOf(TextFieldValue(textSchool)) }

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
        Loader(BASE_URL_LOTTIE_PROFILE_lf20_START, false)
        Text(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .weight(0.5f)
                .padding(20.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 5.em,
            text = " ${name.text} ${surname.text}",
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
            value = name,
            label = { Text(text = stringResource(id = R.string.name), fontWeight = FontWeight.Bold) },
            onValueChange = { value ->
                if (isValidInput(value.text)) {
                    name = value
                } else {
                    showToast(context, message = R.string.toast_valid_name)
                }
            }
        )
        Spacer(modifier = Modifier.size(15.dp))

        OutlinedTextField(
            value = surname,
            label = { Text(text = stringResource(id = R.string.surname), fontWeight = FontWeight.Bold) },
            onValueChange = { value ->
                if (isValidInput(value.text)) {
                    surname = value
                } else {
                    showToast(context, message = R.string.toast_valid_surname)
                }
            }
        )
        Spacer(modifier = Modifier.size(15.dp))

        OutlinedTextField(
            value = school,
            label = { Text(text = stringResource(id = R.string.school), fontWeight = FontWeight.Bold) },
            onValueChange = { value ->
                if (isValidInput(value.text)) {
                    school = value
                } else {
                    showToast(context, message = R.string.toast_valid_school)
                }
            }
        )

        Spacer(modifier = Modifier.size(30.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                onClick = {
                    name = TextFieldValue("")
                    surname = TextFieldValue("")
                    school = TextFieldValue("")
                }
            ) {
                Text(overflow = TextOverflow.Ellipsis ,maxLines = 1,text = stringResource(id = R.string.clear))
            }

            Button(
                modifier = Modifier
                    .weight(0.5f)
                    .padding(SpacingCustom_6dp),
                onClick = {
                    if( name.text.isNotEmpty() &&
                        surname.text.isNotEmpty() &&
                        school.text.isNotEmpty()
                    ) {
                        setUDM(
                            viewModel = viewModel,
                            name.text,
                            surname.text,
                            school.text
                        )
                        showToast(context,message = R.string.toast_valid_save)
                        onGoBack.invoke()
                    }
                    else {
                        showToast(context,message = R.string.toast_non_valid_fill_textfield)
                    }
                }) {
                Text(text = stringResource(id = R.string.save))
            }
        }

        Spacer(modifier = Modifier.size(30.dp))

        Loader(BASE_URL_LOTTIE_PROFILE_lf20_END, true)
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

fun showToast(context: Context, message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
fun isValidInput(text: String): Boolean {
    // Remove leading and trailing whitespaces
    val trimmedText = text.trim()

    // Check if the trimmed text is empty
    return trimmedText.isNotEmpty()
}