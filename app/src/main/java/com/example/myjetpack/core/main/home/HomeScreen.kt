package com.example.myjetpack.core.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.core.main.Screens
import com.example.myjetpack.core.theme.fontSfProRounded
import com.example.myjetpack.data.BaseTitle
import com.example.myjetpack.data.models.MealCategory
import com.example.myjetpack.data.models.MealItem
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(state = scrollState, orientation = Orientation.Vertical),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 50.dp)
                .align(Alignment.Start),
            R.string.home_title
        )
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(onClick = { navController.navigate(Screens.SearchScreens.route) })
        Spacer(modifier = Modifier.height(24.dp))
        MealCategoryList(homeViewModel.mealCategories.value.categories) { homeViewModel.getMealListByCategory(it) }
        Spacer(modifier = Modifier.height(24.dp))
        ListMeals(homeViewModel.mealList.value.meals, navController)
    }
}

@Composable
fun MealCategoryList(categories: List<MealCategory>, onCategoryClicked: (category: String) -> Unit) {
    var selectedCategoryIndex by rememberSaveable { mutableStateOf(0) }
    LazyRow(contentPadding = PaddingValues(start = 50.dp, end = 10.dp)) {
        itemsIndexed(items = categories) { index, category ->
            MealCategoryItem(
                item = category,
                selected = selectedCategoryIndex == index
            ) {
                selectedCategoryIndex = index
                onCategoryClicked(it)
            }
        }
    }
}

@Composable
fun ListMeals(mealsList: List<MealItem>, navController: NavHostController) {
    LazyRow(contentPadding = PaddingValues(start = 50.dp)) {
        itemsIndexed(items = mealsList) { index, meal ->
            FoodItem(meal = meal, navController)
        }
    }
}

@Composable
fun SearchBar(onClick: () -> Unit) {
    Card(
        elevation = 1.dp,
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = { onClick() }
            )
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.nav_favorites),
                contentDescription = "null"
            )
            Text(
                text = "Search",
                modifier = Modifier.padding(horizontal = 14.dp)
            )
        }
    }
}

@Composable
fun MealCategoryItem(item: MealCategory, selected: Boolean, onSelected: (category: String) -> Unit) {
    Column(
        Modifier
            .width(IntrinsicSize.Min)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = { onSelected(item.category) }
            )
//            .selectable(
//                selected = selected,
//                indication = null,
//                interactionSource = MutableInteractionSource(),
//                onClick = {
//                    onSelected()
//                },
//
//            )
    ) {
        Text(
            text = item.category,
            modifier = Modifier
                .padding(horizontal = 12.dp)
        )
        Divider(Modifier.fillMaxWidth().alpha(if (selected) 1f else 0f), Color.Red, 2.dp)
    }
}

@Composable
fun FoodItem(meal: MealItem, navController: NavHostController) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(top = 90.dp)
            .height(248.dp)
            .clickable { navController.navigate(Screens.DetailsScreens.route) }
    ) {
        CardWithText(meal)
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
                .offset(y = (-90).dp)
                .shadow(
                    elevation = 9.dp,
                    shape = CircleShape,
                    clip = true
                )
                .padding(bottom = 4.dp)
                .clip(CircleShape)
                .size(164.dp)
                .align(Alignment.TopCenter),
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            ),
            previewPlaceholder = R.drawable.alfiesweater

        )
    }
    Spacer(modifier = Modifier.width(16.dp))
}

@Composable
fun CardWithText(meal: MealItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(220.dp)
                .height(248.dp),
            contentAlignment = Alignment.Center
        ) {
            Column() {
                Text(
                    text = meal.strMeal,
                    fontFamily = fontSfProRounded,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 50.dp)
                .align(Alignment.Start),
            R.string.home_title
        )
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(onClick = { })
        Spacer(modifier = Modifier.height(24.dp))
        MealCategoryList(MockedDataHome.listOfCategory) {}
        Spacer(modifier = Modifier.height(24.dp))
        ListMeals(MockedDataHome.listOfItems, rememberNavController())
    }
}
