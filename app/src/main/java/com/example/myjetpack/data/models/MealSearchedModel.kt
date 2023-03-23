package com.example.myjetpack.data.models

import com.google.gson.annotations.SerializedName

data class MealSearchedModel(@SerializedName("meals") val listOfSearchedMeals: List<MealSearchedItem>?)

data class MealSearchedItem(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val name: String,
    @SerializedName("strInstructions") val instructions: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
    @SerializedName("strTags") val tags: String,
    @SerializedName("strYoutube") val youtubeLink: String? = "",
    @SerializedName("strIngredient1") val ingredient1: String? = "",
    @SerializedName("strIngredient2") val ingredient2: String? = "",
    @SerializedName("strIngredient3") val ingredient3: String? = "",
    @SerializedName("strIngredient4") val ingredient4: String? = "",
    @SerializedName("strIngredient5") val ingredient5: String? = "",
    @SerializedName("strIngredient6") val ingredient6: String? = "",
    @SerializedName("strIngredient7") val ingredient7: String? = "",
    @SerializedName("strMeasure1") val measure1: String? = "",
    @SerializedName("strMeasure2") val measure2: String? = "",
    @SerializedName("strMeasure3") val measure3: String? = "",
    @SerializedName("strMeasure4") val measure4: String? = "",
    @SerializedName("strMeasure5") val measure5: String? = "",
    @SerializedName("strMeasure6") val measure6: String? = "",
    @SerializedName("strMeasure7") val measure7: String? = ""

)
