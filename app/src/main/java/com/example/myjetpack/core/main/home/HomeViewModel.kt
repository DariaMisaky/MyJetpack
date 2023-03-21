package com.example.myjetpack.core.main.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myjetpack.data.models.MealCategories
import com.example.myjetpack.shared.base.Result
import com.example.myjetpack.shared.usecases.GetMealCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMealCategoriesUseCase: GetMealCategoriesUseCase
) : ViewModel() {

    private val _mealCategories = mutableStateOf<MealCategories>(MealCategories(emptyList()))
    val mealCategories: State<MealCategories> = _mealCategories

    init {
        getMealCategories()
    }

    private fun getMealCategories() {
        viewModelScope.launch {
            when (val result = getMealCategoriesUseCase.run(Unit)) {
                is Result.Success -> {
                    _mealCategories.value = result.data
                    Log.d(TAG, "getMealCategories: ${_mealCategories.value}")
                }
                is Result.Error -> Log.d("ContentValue", result.error)
                else -> {}
            }
        }
    }
}
