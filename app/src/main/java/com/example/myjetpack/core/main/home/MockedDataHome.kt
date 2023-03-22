package com.example.myjetpack.core.main.home

import com.example.myjetpack.data.models.MealCategory
import com.example.myjetpack.data.models.MealItem

object MockedDataHome {
    val listOfCategory: List<MealCategory> =
        listOf(
            MealCategory("1", "Beef", "thumb", "Description"),
            MealCategory("2", "Chicken", "thumb", "Description"),
            MealCategory("3", "Dessert", "thumb", "Description"),
            MealCategory("4", "Lamb", "thumb", "Description"),
            MealCategory("5", "Miscellaneous", "thumb", "Description")

        )
    val listOfItems: List<MealItem> =
        listOf(
            MealItem(
                "Ayam Percik",
                "https://www.themealdb.com/images/media/meals/020z181619788503.jpg",
                "53050"
            ),
            MealItem(
                "Brown Stew Chicken",
                "https://www.themealdb.com/images/media/meals/020z181619788503.jpg",
                "53050"
            ),
            MealItem(
                "Chick-Fil-A Sandwich",
                "https://www.themealdb.com/images/media/meals/020z181619788503.jpg",
                "53050"
            ),
            MealItem(
                "Chicken & mushroom Hotpot",
                "https://www.themealdb.com/images/media/meals/020z181619788503.jpg",
                "53050"
            ),
            MealItem(
                "Chicken Congee",
                "https://www.themealdb.com/images/media/meals/020z181619788503.jpg",
                "53050"
            )
        )
}
