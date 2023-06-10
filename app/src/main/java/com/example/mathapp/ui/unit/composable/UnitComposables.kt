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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mathapp.R
import com.example.mathapp.ui.theme.BabyBluePurple1
import com.example.mathapp.ui.theme.BabyBluePurple3
import com.example.mathapp.ui.theme.FbColor

@Composable
fun Loader(link: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url(link))


    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        clipSpec = LottieClipSpec.Progress(0.1f, 0.70f),
        modifier = Modifier.aspectRatio(1f),

        )
}

@Composable
fun UnitScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BabyBluePurple3)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            modifier = Modifier

        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    maxLines = 1,
                    text = "  Επέλεξε Ενότητα",
                    textAlign = TextAlign.Center,
                    color = BabyBluePurple1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 7.em,
                    fontFamily = FontFamily.Monospace,
                    //modifier = Modifier.fillMaxSize(0.5f),


                )
            }

            Loader(link = "https://assets6.lottiefiles.com/packages/lf20_zunhpwue.json")

        }

        val context = LocalContext.current
        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = { val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-1_1.html"))
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)


            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    maxLines = 1,
                    text = "Ενότητα 1",
                    fontSize = 4.em
                )
            }



            Button(
                onClick = { val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-2_8.html"))
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(

                    maxLines = 1,
                    text = "Ενότητα 2",
                    fontSize = 4.em
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = { val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-3_13.html"))
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)


            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    maxLines = 1,
                    text = "Ενότητα 3",
                    fontSize = 4.em
                )
            }



            Button(
                onClick = { val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-4_22.html"))
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(

                    maxLines = 1,
                    text = "Ενότητα 4",
                    fontSize = 4.em
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = {  val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-5_25.html"))
                    context.startActivity(intent)},
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)


            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    maxLines = 1,
                    text = "Ενότητα 5",
                    fontSize = 4.em
                )
            }



            Button(
                onClick = {val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-6_33.html"))
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(

                    maxLines = 1,
                    text = "Ενότητα 6",
                    fontSize = 4.em
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = {val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-7_36.html")
                )
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)


            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    maxLines = 1,
                    text = "Ενότητα 7",
                    fontSize = 4.em
                )
            }



            Button(
                onClick = { val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://ebooks.edu.gr/ebooks/v/html/8547/2282/Mathimatika_E-Dimotikou_html-empl/index-8_45.html"))
                    context.startActivity(intent) },
                modifier = Modifier
                    .weight(0.5f)
                    .padding(6.dp)
                    .aspectRatio(1f),
                contentPadding = ButtonDefaults.TextButtonContentPadding,
                colors = ButtonDefaults.buttonColors(FbColor)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_menu_book_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(25.dp)

                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(

                    maxLines = 1,
                    text = "Ενότητα 8",
                    fontSize = 4.em
                )
            }
        }

    }
}

@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url("https://assets8.lottiefiles.com/packages/lf20_pan8jtpf.json"))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}


