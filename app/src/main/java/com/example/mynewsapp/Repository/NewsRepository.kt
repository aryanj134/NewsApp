package com.example.mynewsapp.Repository

import android.util.Log
import com.example.mynewsapp.Data.News
import com.example.mynewsapp.Interface.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository(private val newsService: NewsService){
    suspend fun getNews() : Response<News>{
        return newsService.getNews()
    }
}