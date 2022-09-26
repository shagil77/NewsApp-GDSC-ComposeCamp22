package com.gdsc.newsapp.data.remote

import com.gdsc.newsapp.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=ece5d3a457b743d382c1c74544414d0d
    @GET("top-headlines")
    suspend fun getNewsArticle(
        @Query("country") country:String = "us",
        @Query("apiKey") apiKey:String = "ece5d3a457b743d382c1c74544414d0d"
    ):Response<NewsDTO>
}