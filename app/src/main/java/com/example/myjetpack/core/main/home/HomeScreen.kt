package com.example.myjetpack.core.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.Screens
import com.example.myjetpack.core.data.BaseTitle
import com.example.myjetpack.core.data.MealCategoryModel

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(42.dp))
        BaseTitle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.Start),
            R.string.home_title
        )
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(onClick = { navController.navigate(Screens.TipScreen.route) })
        Spacer(modifier = Modifier.height(48.dp))
        MealCategoryList(
            categories = listOf(
                MealCategoryModel(1, "Daria"),
                MealCategoryModel(2, "are"),
                MealCategoryModel(3, "mere"),
                MealCategoryModel(4, "Alfie"),
                MealCategoryModel(5, "le"),
                MealCategoryModel(6, "mananca"),
                MealCategoryModel(7, "pe ")
            )
        )
    }
}

@Composable
fun MealCategoryList(categories: List<MealCategoryModel>) {
    var selectedCategoryIndex by rememberSaveable { mutableStateOf(-1) }
    LazyRow {
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
        Modifier.width(IntrinsicSize.Min)
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
fun Preview() {
    HomeScreen(navController = rememberNavController())
}
