package com.gdsc.newsapp.di

import com.gdsc.newsapp.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideApiService():ApiService {
        return Retrofit.Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}