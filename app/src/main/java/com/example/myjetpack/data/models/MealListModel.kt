package com.example.myjetpack.data.models

import com.google.gson.annotations.SerializedName

data class MealListModel(
    @SerializedName("meals") val meals: List<MealItem>
)

data class MealItem(
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
    @SerializedName("idMeal") val idMeal: String
)
