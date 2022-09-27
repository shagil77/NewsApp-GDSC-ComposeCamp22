package com.gdsc.newsapp.domain.repository

import com.gdsc.newsapp.domain.model.Article

interface GetNewsArticleRepository {
    suspend fun getNewsArticles():List<Article>
}