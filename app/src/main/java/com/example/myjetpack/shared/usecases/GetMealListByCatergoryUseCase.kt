package com.example.myjetpack.shared.usecases

import com.example.myjetpack.data.models.MealListModel
import com.example.myjetpack.data.repository.FoodRepository
import com.example.myjetpack.shared.base.BaseUseCase
import com.example.myjetpack.shared.base.Result
import com.example.myjetpack.shared.utils.Constants
import javax.inject.Inject

class GetMealListByCatergoryUseCase @Inject constructor(private val mainRepo: FoodRepository) :
    BaseUseCase<String, MealListModel>() {
    override suspend fun run(params: String): Result<MealListModel> {
        return try {
            Result.Success(mainRepo.getMealsFromCategory(params))
        } catch (e: Throwable) {
            Result.Error(e.message ?: Constants.GENERIC_ERROR)
        }
    }
}
