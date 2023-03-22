package com.example.myjetpack.data.repository

import com.example.myjetpack.data.api.FoodApi
import com.example.myjetpack.data.models.MealCategories
import com.example.myjetpack.data.models.MealListModel
import javax.inject.Inject

interface FoodRepository {
    suspend fun getMealCategories(): MealCategories

    suspend fun getMealsFromCategory(category: String): MealListModel
}

class FoodRepositoryImpl @Inject constructor(private val api: FoodApi) : FoodRepository {
    override suspend fun getMealCategories(): MealCategories {
        return api.getMealCategories()
    }

    override suspend fun getMealsFromCategory(category: String): MealListModel {
        return api.getMealsFromCategory(category)
    }
}
