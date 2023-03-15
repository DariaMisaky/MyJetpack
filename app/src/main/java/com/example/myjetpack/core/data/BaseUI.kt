package com.example.myjetpack.core.data // ktlint-disable filename

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.myjetpack.core.theme.fontSfProRounded

@Composable
fun BaseTitle(modifier: Modifier, text: Int) {
    Text(
        text = stringResource(text),
        fontFamily = fontSfProRounded,
        textAlign = TextAlign.Start,
        modifier = modifier,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 42.sp
    )
}
