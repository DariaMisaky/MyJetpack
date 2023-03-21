package com.example.myjetpack

import com.example.myjetpack.data.api.FoodApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideFoodApi(): FoodApi {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodApi::class.java)
    }
//    @Singleton
//    @Provides
//    fun provideMockAPI(
//        retrofit: Retrofit
//    ): FoodApi = retrofit.create(FoodApi::class.java)
}
