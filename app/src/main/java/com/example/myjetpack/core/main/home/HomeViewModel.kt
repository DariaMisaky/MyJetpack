package com.example.myjetpack.core.main.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myjetpack.data.models.MealCategories
import com.example.myjetpack.data.models.MealListModel
import com.example.myjetpack.shared.base.Result
import com.example.myjetpack.shared.usecases.GetMealCategoriesUseCase
import com.example.myjetpack.shared.usecases.GetMealListByCatergoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMealCategoriesUseCase: GetMealCategoriesUseCase,
    private val getMealListByCategoryUseCase: GetMealListByCatergoryUseCase
) : ViewModel() {

    private val _mealCategories = mutableStateOf(MealCategories(mutableListOf()))
    val mealCategories: State<MealCategories> = _mealCategories

    private val _mealList = mutableStateOf(MealListModel(mutableListOf()))
    val mealList: State<MealListModel> = _mealList

    init {
        getMealCategories()
    }

    private fun getMealCategories() {
        viewModelScope.launch {
            when (val result = getMealCategoriesUseCase.run(Unit)) {
                is Result.Success -> {
                    _mealCategories.value = result.data
                    getMealListByCategory(result.data.categories.first().category)
                }
                is Result.Error -> Log.d("ContentValue", result.error)
                else -> {}
            }
        }
    }

    fun getMealListByCategory(category: String) {
        viewModelScope.launch {
            when (val result = getMealListByCategoryUseCase.run(category)) {
                is Result.Success -> {
                    _mealList.value = result.data
                }
                is Result.Error -> Log.d("ContentValue", result.error)
                else -> {}
            }
        }
    }
}
