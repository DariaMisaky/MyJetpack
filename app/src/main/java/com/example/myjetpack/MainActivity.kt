package com.example.myjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Conversation(conversationSample)
        }
    }

    @Composable
    fun MessageCard(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            var isExpanded by rememberSaveable { mutableStateOf(true) }
            var canExpand by rememberSaveable { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(
                if (isExpanded) colorResource(id = R.color.white) else colorResource(id = androidx.core.R.color.androidx_core_ripple_material_light)
            )
            Image(
                painter = painterResource(id = R.drawable.alfiesweater),
                contentDescription = null,
                // fills the circle
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(50.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = message.title,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Surface(
                    color = surfaceColor,
                    modifier = Modifier
                        .clickable { isExpanded = !isExpanded },
                    shape = RectangleShape,
                    elevation = 1.dp

                ) {
                    Column() {
                        Text(
                            text = message.body,
                            modifier = Modifier
                                .padding(all = 16.dp),
                            // If the message is expanded, we display all its content
                            // otherwise we only display the first line
                            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                            onTextLayout = { textLayoutResult: TextLayoutResult ->
                                canExpand = textLayoutResult.lineCount > 1
                            },
                            style = MaterialTheme.typography.body2
                        )
                        if (!isExpanded && !canExpand) {
                            Button(
                                onClick = { isExpanded = true },
                                Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth()
                                    .padding(horizontal = 80.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = MaterialTheme.colors.secondaryVariant,
                                    contentColor = Color.White
                                )
                            ) {
                                Text("Show more")
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message = message)
            }
        }
    }

    data class Message(
        val title: String,
        val body: String
    )

    val conversationSample = listOf(
        Message(
            "Alfie",
            "Test...Test...Test..."
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfred Bradescu",
            "Nu mai fac caca in casa"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        ),
        Message(
            "Alfie",
            "List of Android versions:\n" +
                "Android KitKat (API 19)\n" +
                "Android Lollipop (API 21)\n" +
                "Android Marshmallow (API 23)\n" +
                "Android Nougat (API 24)\n" +
                "Android Oreo (API 26)\n" +
                "Android Pie (API 28)\n" +
                "Android 10 (API 29)\n" +
                "Android 11 (API 30)\n" +
                "Android 12 (API 31)\n"
        )

    )

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        Conversation(conversationSample)
    }
}
