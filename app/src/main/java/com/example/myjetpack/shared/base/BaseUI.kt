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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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

@Composable
fun BackButton(navController: NavHostController) {
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = null,
        tint = Color.Black,
        modifier = Modifier.padding(20.dp).size(34.dp).clickable { navController.popBackStack() }
    )
}
