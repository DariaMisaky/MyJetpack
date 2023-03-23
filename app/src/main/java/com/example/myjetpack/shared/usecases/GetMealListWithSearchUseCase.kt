package com.example.myjetpack.shared.usecases

import com.example.myjetpack.data.models.MealSearchedModel
import com.example.myjetpack.data.repository.FoodRepository
import com.example.myjetpack.shared.base.BaseUseCase
import com.example.myjetpack.shared.base.Result
import com.example.myjetpack.shared.utils.Constants
import javax.inject.Inject

class GetMealListWithSearchUseCase @Inject constructor(private val mainRepo: FoodRepository) :
    BaseUseCase<String, MealSearchedModel>() {
    override suspend fun run(params: String): Result<MealSearchedModel> {
        return try {
            Result.Success(mainRepo.getSearchedMeals(params))
        } catch (e: Throwable) {
            Result.Error(e.message ?: Constants.GENERIC_ERROR)
        }
    }
}
