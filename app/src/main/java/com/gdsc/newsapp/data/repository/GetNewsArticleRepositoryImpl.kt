package com.gdsc.newsapp.data.repository

import com.gaur.composenewsapplication.utils.SafeApiRequest
import com.gdsc.newsapp.data.mapper.toArticle
import com.gdsc.newsapp.data.remote.ApiService
import com.gdsc.newsapp.domain.model.Article
import com.gdsc.newsapp.domain.repository.GetNewsArticleRepository
import javax.inject.Inject

class GetNewsArticleRepositoryImpl @Inject constructor(
    private val apiService: ApiService
    ) : GetNewsArticleRepository, SafeApiRequest(){

    override suspend fun getNewsArticles(): List<Article> {
        val response = safeApiRequest { apiService.getNewsArticle() }
        return response.articles?.toArticle()!!
    }

}