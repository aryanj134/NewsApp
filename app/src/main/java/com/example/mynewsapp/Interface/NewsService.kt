package com.example.mynewsapp.Interface

import com.example.mynewsapp.Data.News
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {

    //specify the end part of the url
    @GET("NewsAPI/sources.json")
    suspend fun getNews() : Response<News>
}