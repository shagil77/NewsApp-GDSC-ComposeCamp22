package com.gdsc.newsapp.presentation

import com.gdsc.newsapp.domain.model.Article

data class HomeScreenState(
    val isLoading:Boolean = false,
    val data:List<Article>?=null,
    val error:String = ""
)
