package com.example.mathapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mathapp.R

val helveticaFontFamily = FontFamily(
    Font(R.font.helvetica_neue_world_roman),
    Font(R.font.helvetica_neue_world_roman, style = FontStyle.Italic),
    Font(R.font.helvetica_neue_world_light, weight = FontWeight.Light),
    Font(R.font.helvetica_neue_world_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.helvetica_neue_world_bold, weight = FontWeight.Bold),
    Font(R.font.helvetica_neue_world_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
)
// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 80.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = helveticaFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)


