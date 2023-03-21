package com.example.myjetpack.data.models

import com.google.gson.annotations.SerializedName

data class MealCategories(
    @SerializedName("categories") val categories: List<MealCategory>
)

data class MealCategory(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val category: String,
    @SerializedName("strCategoryThumb") val categoryThumb: String,
    @SerializedName("strCategoryDescription") val description: String
)
