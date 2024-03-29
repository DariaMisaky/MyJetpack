package com.example.myjetpack.core.main.tipScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.core.main.Screens
import com.example.myjetpack.data.BackButton
import com.example.myjetpack.data.BaseTitle
import java.text.NumberFormat

@Composable
fun TipScreen(navController: NavHostController) {
    var amountValue by remember { mutableStateOf("") }
    val amount = amountValue.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)
    BackButton(navController)
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.CenterHorizontally),
            text = R.string.app_name
        )
        Spacer(modifier = Modifier.height(16.dp))
        EditNumberField(
            modifier = Modifier
                .fillMaxWidth(),
            amountValue = amountValue,
            onValueChange = { amountValue = it }
        )
        Spacer(Modifier.height(24.dp))
        Text(
            text = stringResource(id = R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        GeneralButton(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.BottomCenter),
            onClick = { navController.navigate(Screens.FavoritesScreens.route) }
        )
    }
}

@Composable
fun EditNumberField(modifier: Modifier, amountValue: String, onValueChange: (String) -> Unit) {
    TextField(
        value = amountValue,
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        label = {
            Label(modifier = Modifier.wrapContentSize())
        }
    )
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun Label(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.alfiesweater),
            contentDescription = "Alfie",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(20.dp)

        )
        Text(text = "Bill Amount", modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun GeneralButton(modifier: Modifier, onClick: () -> Unit) {
    Column(modifier = modifier) {
        Button(onClick = onClick) {
            Text(stringResource(id = R.string.next_screen))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TipScreen(navController = rememberNavController())
}
