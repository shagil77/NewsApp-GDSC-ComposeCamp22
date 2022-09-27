package com.gdsc.newsapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.composenewsapplication.utils.Resource
import com.gdsc.newsapp.domain.model.Article
import com.gdsc.newsapp.util.GetNewsArticleUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeScreenViewModel @Inject constructor(
    private val getNewsArticleUseCase: GetNewsArticleUseCase
    ):ViewModel() {

    val article = mutableStateOf(HomeScreenState())

    fun getNewsArticle() {
        getNewsArticleUseCase().onEach {
            when(it) {
                is Resource.Loading->{
                    article.value = HomeScreenState(isLoading = true)
                }
                is Resource.Success->{
                    article.value = HomeScreenState(data = it.data)
                }
                is Resource.Error->{
                    article.value = HomeScreenState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}