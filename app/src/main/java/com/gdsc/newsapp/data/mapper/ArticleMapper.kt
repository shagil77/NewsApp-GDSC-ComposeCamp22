package com.gdsc.newsapp.data.mapper

import com.gdsc.newsapp.data.model.ArticleDTO
import com.gdsc.newsapp.domain.model.Article

fun List<ArticleDTO>.toArticle():List<Article> {
    return map{ articleDTO ->
        Article(
            content = articleDTO.content?:"",
            description = articleDTO.description?:"",
            title = articleDTO.title?:"",
            urlToImage = articleDTO.urlToImage?:""
        )
    }
}