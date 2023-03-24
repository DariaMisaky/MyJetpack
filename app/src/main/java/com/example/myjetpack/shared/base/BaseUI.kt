package com.example.myjetpack.data // ktlint-disable filename

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myjetpack.core.theme.fontSfProRounded

@OptIn(ExperimentalTextApi::class)
@Composable
fun BaseTitle(modifier: Modifier, text: Int) {
    val gradientColors = listOf(Cyan, Blue, Red, Yellow)
    val offset = Offset(200.0f, 120.0f)
    Text(
        text = stringResource(text),
        fontFamily = fontSfProRounded,
        textAlign = TextAlign.Start,
        modifier = modifier,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
            // shadow = Shadow(Black, offset = offset, blurRadius = 20f)
        ),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 42.sp
    )
}

@Composable
fun BackButton(navController: NavHostController, paddingTopValue: Dp = 20.dp, paddingBottomValue: Dp = 20.dp) {
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = null,
        tint = Color.Black,
        modifier = Modifier.padding(
            top = paddingTopValue,
            bottom = paddingBottomValue,
            start = 20.dp,
            end = 20.dp
        )
            .size(34.dp).clickable { navController.popBackStack() }
    )
}
