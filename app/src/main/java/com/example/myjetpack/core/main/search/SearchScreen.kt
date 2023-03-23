package com.example.myjetpack.core.main.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.core.main.home.MockedDataHome
import com.example.myjetpack.core.theme.fontSfProRounded
import com.example.myjetpack.data.BackButton
import com.example.myjetpack.data.BaseTitle
import com.example.myjetpack.data.models.MealItem
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreenComposable(navController)
}

@Composable
fun SearchScreenComposable(navController: NavHostController) {
    var searchedValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.myGrey))
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        BackButtonAndTextField(navController, searchedValue) { searchedValue = it }
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxSize()
                .offset(y = 20.dp),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 50.dp)
            ) {
                BaseTitle(
                    modifier = Modifier
                        .align(Alignment.Start),
                    text = R.string.home_title
                )
                ListMealsSearch(mealsList = MockedDataHome.listOfItems)
            }
        }
    }
}

@Composable
fun BackButtonAndTextField(navController: NavHostController, searchedValue: String, onValueChange: (String) -> Unit) {
    Row {
        BackButton(navController)
        TextField(
            modifier = Modifier.offset(y = 10.dp),
            value = searchedValue,
            maxLines = 1,
            onValueChange = { onValueChange(it) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.Transparent,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                HintTextField(modifier = Modifier.wrapContentSize())
            }

        )
    }
}

@Composable
fun HintTextField(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Search food Here", modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun ListMealsSearch(mealsList: List<MealItem>) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(bottom = 24.dp, top = 10.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        itemsIndexed(items = mealsList) { index, meal ->
            Box(
                modifier = if (index % 2 == 1) {
                    Modifier.padding(top = 40.dp)
                } else {
                    Modifier
                }
            ) {
                FoodItemSearch(meal = meal)
            }
        }
    }
}

@Composable
fun FoodItemSearch(meal: MealItem) {
    CardWithTextSearch(meal)
}

@Composable
fun CardWithTextSearch(meal: MealItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp,
        modifier = Modifier
            .height(200.dp)
            .padding(bottom = 10.dp)
    ) {
        Column {
            GlideImage(
                imageModel = { meal.strMealThumb },
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = Color.Gray

                        )
                    }
                },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .shadow(
                        elevation = 16.dp,
                        shape = CircleShape,
                        clip = true
                    )
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape),
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                previewPlaceholder = R.drawable.alfiesweater

            )
            Text(
                text = meal.strMeal,
                fontFamily = fontSfProRounded,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    SearchScreenComposable(navController = rememberNavController())
}
