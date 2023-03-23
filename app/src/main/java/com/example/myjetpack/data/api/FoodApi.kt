package com.example.myjetpack.data.api

import com.example.myjetpack.data.models.MealCategories
import com.example.myjetpack.data.models.MealListModel
import com.example.myjetpack.data.models.MealSearchedModel
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getMealCategories(): MealCategories

    @GET("api/json/v1/1/filter.php")
    suspend fun getMealsFromCategory(@Query("c") category: String): MealListModel

    @GET("api/json/v1/1/search.php")
    suspend fun getSearchedMeals(@Query("s") text: String): MealSearchedModel

    //    @GET("api/json/v1/1/lookup.php")
//    suspend fun getMealDetails(@Query("i") id: String): MealDetails
}
