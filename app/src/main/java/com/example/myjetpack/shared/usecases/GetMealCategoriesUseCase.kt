package com.example.myjetpack.shared.usecases

import com.example.myjetpack.data.models.MealCategories
import com.example.myjetpack.data.repository.FoodRepository
import com.example.myjetpack.shared.base.BaseUseCase
import com.example.myjetpack.shared.base.Result
import com.example.myjetpack.shared.utils.Constants
import javax.inject.Inject

class GetMealCategoriesUseCase @Inject constructor(private val mainRepo: FoodRepository) :
    BaseUseCase<Unit, MealCategories>() {
    override suspend fun run(params: Unit): Result<MealCategories> {
        return try {
            Result.Success(mainRepo.getMealCategories())
        } catch (e: Throwable) {
            Result.Error(e.message ?: Constants.GENERIC_ERROR)
        }
    }
}
