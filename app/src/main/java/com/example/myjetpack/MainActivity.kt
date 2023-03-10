package com.example.myjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions // ktlint-disable no-wildcard-imports
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyUI()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MyUI() {
        var amountValue by remember { mutableStateOf("") }
        val amount = amountValue.toDoubleOrNull() ?: 0.0
        val tip = calculateTip(amount)
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Title(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            EditNumberField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
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
            Button(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
            )
        }
    }

    @Composable
    fun Title(modifier: Modifier) {
        Text(
            text = stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            modifier = modifier,
            fontSize = 24.sp
        )
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
    fun Button(modifier: Modifier) {
        Column(modifier = modifier) {
            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(id = R.string.app_name))
            }
        }
    }
}
