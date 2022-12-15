package com.example.mathapp.ui.profile.composable

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.*
import com.airbnb.lottie.compose.*
import com.example.mathapp.data.room.entity.UserEntity
import com.example.mathapp.ui.profile.ProfileViewModel
import com.example.mathapp.ui.profile.setUDM
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {


    var dt = viewModel.readAllData.observeAsState(listOf()).value

    //var list : UserDataModel


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

        if (dt.equals(emptyList<UserEntity>())) {
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


// create a composable to
// Draw arc and handle
@Composable
fun Timer(

    // total time of the timer
    totalTime: Long,

    // circular handle color
    handleColor: Color,

    // color of inactive bar / progress bar
    inactiveBarColor: Color,

    // color of active bar
    activeBarColor: Color,
    modifier: Modifier = Modifier,

    // set initial value to 1
    initialValue: Float = 1f,
    strokeWidth: Dp = 5.dp
) {
    // create variable for
    // size of the composable
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    // create variable for value
    var value by remember {
        mutableStateOf(initialValue)
    }
    // create variable for current time
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    // create variable for isTimerRunning
    var isTimerRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(100L)
            currentTime -= 100L
            value = currentTime / totalTime.toFloat()
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .onSizeChanged {
                size = it
            }
    ) {
        // draw the timer
        Canvas(modifier = modifier) {
            // draw the inactive arc with following parameters
            drawArc(
                color = inactiveBarColor, // assign the color
                startAngle = -215f, // assign the start angle
                sweepAngle = 250f, // arc angles
                useCenter = false, // prevents our arc to connect at te ends
                size = Size(size.width.toFloat(), size.height.toFloat()),

                // to make ends of arc round
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            // draw the active arc with following parameters
            drawArc(
                color = activeBarColor, // assign the color
                startAngle = -215f, // assign the start angle
                sweepAngle = 250f * value, // reduce the sweep angle
                // with the current value
                useCenter = false, // prevents our arc to connect at te ends
                size = Size(size.width.toFloat(), size.height.toFloat()),

                // to make ends of arc round
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            // calculate the value from arc pointer position
            val center = Offset(size.width / 2f, size.height / 2f)
            val beta = (250f * value + 145f) * (PI / 180f).toFloat()
            val r = size.width / 2f
            val a = cos(beta) * r
            val b = sin(beta) * r
            // draw the circular pointer/ cap
            drawPoints(
                listOf(Offset(center.x + a, center.y + b)),
                pointMode = PointMode.Points,
                color = handleColor,
                strokeWidth = (strokeWidth * 3f).toPx(),
                cap = StrokeCap.Round // make the pointer round
            )
        }
        // add value of the timer
        Text(
            text = (currentTime / 1000L).toString(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = BabyBluePurple5
        )


        isTimerRunning = true

        /*if(currentTime <= 0L) {
                isTimerRunning = !isTimerRunning
                currentTime = totalTime
                isTimerRunning = true
        } else {
           isTimerRunning = !isTimerRunning
        }*/

        /*
        // create button to start or stop the timer
        Button(
            onClick = {

            },
            modifier = Modifier.align(Alignment.BottomCenter),
            // change button color
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (!isTimerRunning || currentTime <= 0L) {
                    Color.Green
                } else {
                    Color.Red
                }
            )
        ) {
            Text(
                // change the text of button based on values
                text = if (isTimerRunning && currentTime >= 0L) "Stop"
                else if (!isTimerRunning && currentTime >= 0L) "Start"
                else "Restart"
            )
        }*/
    }
}





