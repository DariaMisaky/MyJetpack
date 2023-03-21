package com.example.myjetpack.data.repository

import com.example.myjetpack.data.api.FoodApi
import com.example.myjetpack.data.models.MealCategories
import javax.inject.Inject

interface FoodRepository {
    suspend fun getMealCategories(): MealCategories
}

class FoodRepositoryImpl @Inject constructor(private val api: FoodApi) : FoodRepository {
    override suspend fun getMealCategories(): MealCategories {
        return api.getMealCategories()
    }
}
