package com.petros.efthymiou.dailypulse.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService (private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "6437bea2758645778441cca1ab0b9f03"

    suspend fun fetchArticles(): List<ArticlesRaw>{
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}