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
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.Screens
import com.example.myjetpack.core.data.BaseTitle
import com.example.myjetpack.core.data.MealCategoryModel
import com.example.myjetpack.core.theme.fontSfProRounded

@Composable
fun HomeScreen(
    navController: NavHostController
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
        SearchBar(onClick = { navController.navigate(Screens.TipScreen.route) })
        Spacer(modifier = Modifier.height(24.dp))
        MealCategoryList(
            categories = listOf(
                MealCategoryModel(1, "Alfred"),
                MealCategoryModel(2, "face"),
                MealCategoryModel(3, "9"),
                MealCategoryModel(4, "Ani"),
                MealCategoryModel(5, "in"),
                MealCategoryModel(6, "data"),
                MealCategoryModel(7, "de "),
                MealCategoryModel(8, "7 "),
                MealCategoryModel(8, "iunie ")
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow(contentPadding = PaddingValues(start = 50.dp)) {
            items(4) {
                FoodItem()
            }
        }
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 50.dp)
                .align(Alignment.Start),
            R.string.home_title
        )
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 50.dp)
                .align(Alignment.Start),
            R.string.home_title
        )
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(horizontal = 50.dp)
                .align(Alignment.Start),
            R.string.home_title
        )
    }
}

@Composable
fun MealCategoryList(categories: List<MealCategoryModel>) {
    var selectedCategoryIndex by rememberSaveable { mutableStateOf(-1) }
    LazyRow(contentPadding = PaddingValues(start = 50.dp)) {
        itemsIndexed(items = categories) { index, category ->
            MealCategoryItem(
                item = category,
                selected = selectedCategoryIndex == index,
                onSelected = { selectedCategoryIndex = index }
            )
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
fun MealCategoryItem(item: MealCategoryModel, selected: Boolean, onSelected: () -> Unit) {
    Column(
        Modifier
            .width(IntrinsicSize.Min)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = { onSelected() }
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
            text = item.text,
            modifier = Modifier
                .padding(horizontal = 12.dp)
        )
        if (selected) {
            Divider(Modifier.fillMaxWidth(), Color.Red, 2.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodItem() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(top = 90.dp)
            .wrapContentSize()
    ) {
        CardWithText()
        Image(
            painter = painterResource(id = R.drawable.alfiesweater),
            contentDescription = "Alfie",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .offset(y = (-90).dp)
                .clip(CircleShape)
                .size(164.dp)
                .align(Alignment.TopCenter)

        )
    }
    Spacer(modifier = Modifier.width(16.dp))
}

@Composable
fun CardWithText() {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 10.dp,
        modifier = Modifier.height(300.dp).padding(bottom = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .width(220.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Column() {
                Text(
                    text = "Alfred nu alearga dupa pisici, pentru ca ii este frica de ele",
                    fontFamily = fontSfProRounded,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(navController = rememberNavController())
}
