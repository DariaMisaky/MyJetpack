package com.example.myjetpack.data.network

import com.example.myjetpack.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityRetainedComponent::class)
object NetworkModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    fun provideGsonConverterFactory(
        gson: Gson
    ): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @AuthenticationInterceptor
    fun provideAuthInterceptor(): Interceptor = AuthInterceptor()

    @Provides
    fun provideOkhttpClient(
        @AuthenticationInterceptor authInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor)
            }
        }
        .build()

    @Provides
    fun provideRetrofitClient(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/")
        .addConverterFactory(gsonConverterFactory)
        .client(okHttpClient)
        .build()
}
