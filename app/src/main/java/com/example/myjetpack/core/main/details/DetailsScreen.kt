package com.example.myjetpack.core.main.details

import androidx.compose.foundation.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.core.theme.fontSfPro
import com.example.myjetpack.data.BackButton
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    DetailsScreenComposable(navController)
}

@Composable
fun DetailsScreenComposable(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .verticalScroll(state = rememberScrollState())

    ) {
        BackButtonAndHeart(navController)
        ImageWithDotsAndTitle()
        TagsList()
        TitleSearchScreen("Ingredients", modifier = Modifier.padding(horizontal = 40.dp, vertical = 20.dp))
        IngredientsList()
        TitleSearchScreen("Instructions", modifier = Modifier.padding(horizontal = 40.dp, vertical = 20.dp))
        Text(
            text = "Instructions fsd fds fs fs f sdf s fs fds fs f dsfdsfdsfsdfds",
            modifier = Modifier.padding(horizontal = 40.dp),
            fontFamily = fontSfPro,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun BackButtonAndHeart(navController: NavHostController) {
    Row(modifier = Modifier.fillMaxWidth()) {
        BackButton(navController, paddingTopValue = 36.dp)
        Spacer(modifier = Modifier.fillMaxWidth(0.8f))
        Icon(
            painter = painterResource(id = R.drawable.nav_favorites),
            contentDescription = null,
            modifier = Modifier.padding(top = 42.dp)
        )
    }
}

@Composable
fun TagsList() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 52.dp)
        ) {
            items(2) { TagItem() }
        }
    }
}

@Composable
fun TagItem() {
    Card(
        modifier = Modifier.wrapContentSize(),
        shape = RoundedCornerShape(30.dp),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Text(
            text = "meat",
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            color = Color.Red

        )
    }
}

@Composable
fun ImageWithDotsAndTitle() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageMeal()
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(2) { Dot() }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 20.dp),
            text = stringResource(R.string.app_name),
            fontSize = 28.sp,
            fontFamily = fontSfPro,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun Dot(dotColor: Color = colorResource(id = R.color.grey_dot)) {
    Image(
        painter = painterResource(id = R.drawable.dot),
        contentDescription = null,
        colorFilter = ColorFilter.tint(dotColor),
        modifier = Modifier.size(8.dp)
    )
}

@Composable
fun ImageMeal() {
    GlideImage(
        imageModel = { "https://www.themealdb.com/images/media/meals/qtqwwu1511792650.jpg" },
        loading = {
            Box(modifier = Modifier.matchParentSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Gray

                )
            }
        },
        modifier = Modifier
            .shadow(
                elevation = 9.dp,
                shape = CircleShape,
                clip = true
            )
            .padding(bottom = 4.dp)
            .clip(CircleShape)
            .size(241.dp),
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        ),
        previewPlaceholder = R.drawable.alfiesweater

    )
}

@Composable
fun TitleSearchScreen(text: String, modifier: Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontFamily = fontSfPro,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier
    )
}

@Composable
fun IngredientsList() {
    Column(Modifier.padding(horizontal = 40.dp)) {
        repeat(2) {
            IngredientsItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientsItem() {
    val checkedState = remember { mutableStateOf(true) }

    Row() {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors = CheckboxDefaults.colors(
                checkmarkColor = colorResource(id = R.color.white),
                checkedColor = Color.Gray
            )

        )
        Text(
            text = "3/4 cup" + " ",
            modifier = Modifier.padding(top = 14.dp),
            fontFamily = fontSfPro,
            color = Color.Gray
        )
        Text(
            text = "soy sauce",
            modifier = Modifier.padding(top = 14.dp),
            fontFamily = fontSfPro,
            color = Color.Gray,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    DetailsScreenComposable(navController = rememberNavController())
}
