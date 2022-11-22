package com.example.mathapp.ui.profile.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.airbnb.lottie.compose.*
import com.example.mathapp.ui.theme.BabyBluePurple2
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.BabyBluePurple5


@Composable
fun ProfileScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var textState1 by remember { mutableStateOf(TextFieldValue("Jonnys")) }
        var textState2 by remember { mutableStateOf(TextFieldValue("PapaJonnys")) }

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
                text = " ${textState1.text} ${textState2.text}",
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
                value = textState1,
                label = { Text("Όνομα", fontWeight = FontWeight.Bold) },
                onValueChange = {
                    textState1 = it

                })
            Spacer(modifier = Modifier.size(15.dp))
            OutlinedTextField(
                value = textState2,
                label = { Text("Επίθετο", fontWeight = FontWeight.Bold) },
                onValueChange = {
                    textState2 = it

                })
            Spacer(modifier = Modifier.size(15.dp))

            OutlinedTextField(
                value = textState1,
                label = { Text("Σχολείο", fontWeight = FontWeight.Bold) },
                onValueChange = {
                    textState1 = it

                })
            Spacer(modifier = Modifier.size(30.dp))
            Button(modifier = Modifier.fillMaxWidth(0.5f), onClick = { /*TODO*/ }) {
                Text(text = "Αποθήκευση!")
            }
            // Loader("https://assets8.lottiefiles.com/private_files/lf30_wfox4afo.json",true)
            Spacer(modifier = Modifier.size(30.dp))


        }
        Loader("https://assets10.lottiefiles.com/packages/lf20_xyadoh9h.json", true)
    }


}


@Composable
fun test() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BabyBluePurple2)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(color = BabyBluePurple5, RoundedCornerShape(bottomEnd = 60.dp))
        ) {
            Button(modifier = Modifier.fillMaxWidth(0.5f), onClick = { /*TODO*/ }) {
                Text(text = "Αποθήκευση!")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(color = Color.White, RoundedCornerShape(topStart = 60.dp))
        ) {

            Box(
                modifier = Modifier.background(
                    color = BabyBluePurple2,
                    RoundedCornerShape(topStart = 500.dp)
                )
            ) {
                Button(modifier = Modifier.fillMaxWidth(0.5f), onClick = { /*TODO*/ }) {
                    Text(text = "Αποθήκευση!")
                }
            }
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
            clipSpec = LottieClipSpec.Progress(0.1f, 0.70f),
            modifier = Modifier.aspectRatio(1f),

            )
    } else {

        LottieAnimation(
            composition = composition,
            clipSpec = LottieClipSpec.Progress(0.1f, 0.70f),

            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),

            )
    }
}


@Preview(showBackground = false)
@Composable
fun DrawerItemPreview() {
    ProfileScreen()
}

@Composable
fun IconShow() {
    Icon(
        Icons.Filled.Person,
        contentDescription = "Localized description",
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(16.dp))
    )

}


