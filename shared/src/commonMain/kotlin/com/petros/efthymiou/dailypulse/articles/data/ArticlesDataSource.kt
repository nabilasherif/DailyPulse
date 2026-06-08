package com.petros.efthymiou.dailypulse.articles.data

import com.petros.efthymiou.dailypulse.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {
    fun getAllArticles(): List<ArticlesRaw> =
        database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticlesRaw>){
        database.dailyPulseDatabaseQueries.transaction{
            articles.forEach { articlesRaw ->
                insertArticle(articlesRaw)
            }
        }
    }

    fun clearArticles()=
        database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun insertArticle(articlesRaw: ArticlesRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            articlesRaw.title,
            articlesRaw.desc,
            articlesRaw.date,
            articlesRaw.imageUrl
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url:String?
    ): ArticlesRaw =
        ArticlesRaw(
            title,
            desc,
            date,
            url
        )
}