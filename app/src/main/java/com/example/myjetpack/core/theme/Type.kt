package com.example.myjetpack.core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myjetpack.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
val fontSfProRounded = FontFamily(
    Font(R.font.sf_pro_rounded_semibold, weight = FontWeight.SemiBold),
    Font(R.font.sf_pro_rounded_bold, weight = FontWeight.Bold),
    Font(R.font.sf_pro_rounded_heavy, weight = FontWeight.ExtraBold)
)

val fontSfPro = FontFamily(
    Font(R.font.sf_pro_regular),
    Font(R.font.sf_pro_regular_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.sf_pro_semibold, weight = FontWeight.SemiBold),
    Font(R.font.sf_pro_bold, weight = FontWeight.Bold)
)
