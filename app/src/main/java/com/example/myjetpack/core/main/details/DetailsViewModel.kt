package com.example.myjetpack.core.main.details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myjetpack.data.models.MealSearchedModel
import com.example.myjetpack.shared.base.Result
import com.example.myjetpack.shared.usecases.GetMealListWithSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getMealListWithSearchUseCase: GetMealListWithSearchUseCase
) : ViewModel() {

    private val _mealsSearchedList = mutableStateOf(MealSearchedModel(mutableListOf()))
    val mealsSearchedList: State<MealSearchedModel> = _mealsSearchedList

    init {
        getMealCategories("")
    }

    fun getMealCategories(searchedText: String) {
        viewModelScope.launch {
            when (val result = getMealListWithSearchUseCase.run(searchedText)) {
                is Result.Success -> {
                    _mealsSearchedList.value = result.data
                }
                is Result.Error -> Log.d("ContentValue", result.error)
                else -> {}
            }
        }
    }
}
