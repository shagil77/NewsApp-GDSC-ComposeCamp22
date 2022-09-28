package com.gdsc.newsapp.domain.di

import com.gdsc.newsapp.data.remote.ApiService
import com.gdsc.newsapp.data.repository.GetNewsArticleRepositoryImpl
import com.gdsc.newsapp.domain.repository.GetNewsArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {
    @Provides
    fun provideGetNewsRepository(apiService: ApiService):GetNewsArticleRepository {
        return GetNewsArticleRepositoryImpl(apiService = apiService)
    }
}