package com.petros.efthymiou.dailypulse.articles.data

import com.petros.efthymiou.dailypulse.articles.data.ArticlesService

class ArticlesRepository(private val dataSource: ArticlesDataSource, private val service: ArticlesService) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticlesRaw>{
        if (forceFetch){
            dataSource.clearArticles()
            return fetchArticles()
        }
        val articleDb= dataSource.getAllArticles()
        println("Got ${articleDb.size} from the database!")

        if(articleDb.isEmpty()){
           return fetchArticles()
        }

        return articleDb
    }

    private suspend fun fetchArticles(): List<ArticlesRaw>{
        val fetchedArticles =service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }
}