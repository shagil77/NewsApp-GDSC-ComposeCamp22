package com.gdsc.newsapp.util

import com.gaur.composenewsapplication.utils.Resource
import com.gdsc.newsapp.domain.model.Article
import com.gdsc.newsapp.domain.repository.GetNewsArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticleUseCase @Inject constructor(private val getNewsArticleRepo: GetNewsArticleRepository) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading(""))
        try{
            emit(Resource.Success(getNewsArticleRepo.getNewsArticles()))

        }catch (e:Exception){
            emit(Resource.Error(e.message))
        }

    }

}