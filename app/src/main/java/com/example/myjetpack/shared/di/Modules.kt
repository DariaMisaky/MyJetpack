package com.example.myjetpack.shared.di

import com.example.myjetpack.data.repository.FoodRepository
import com.example.myjetpack.data.repository.FoodRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface Modules {

    @Binds
    @ViewModelScoped
    fun bindMockRepository(impl: FoodRepositoryImpl): FoodRepository

//    @Binds
//    fun bindGetMockItemsUseCase(impl: GetMealCategoriesUseCase): GetMealCategoriesUseCase
}
