package com.example.myjetpack.data.repository

import com.example.myjetpack.data.api.FoodApi
import com.example.myjetpack.data.models.MealCategories
import com.example.myjetpack.data.models.MealListModel
import com.example.myjetpack.data.models.MealSearchedModel
import javax.inject.Inject

interface FoodRepository {
    suspend fun getMealCategories(): MealCategories

    suspend fun getMealsFromCategory(category: String): MealListModel

    suspend fun getSearchedMeals(searched: String): MealSearchedModel
}

class FoodRepositoryImpl @Inject constructor(private val api: FoodApi) : FoodRepository {
    override suspend fun getMealCategories(): MealCategories {
        return api.getMealCategories()
    }

    override suspend fun getMealsFromCategory(category: String): MealListModel {
        return api.getMealsFromCategory(category)
    }

    override suspend fun getSearchedMeals(searched: String): MealSearchedModel {
        return api.getSearchedMeals(searched)
    }
}
