package com.gdsc.newsapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.composenewsapplication.utils.Resource
import com.gdsc.newsapp.domain.model.Article
import com.gdsc.newsapp.util.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getNewsArticleUseCase: GetNewsArticleUseCase
    ):ViewModel() {

    val article = mutableStateOf(HomeScreenState())

    init {
        getNewsArticle()
    }

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