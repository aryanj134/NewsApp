package com.example.mynewsapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynewsapp.Data.NewsItem
import com.example.mynewsapp.Repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository): ViewModel() {
    val newsData : MutableLiveData<List<NewsItem>> = MutableLiveData()

    fun getNews() {
        viewModelScope.launch {
            try {
                val response = newsRepository.getNews()
                if (response.isSuccessful) {
                    newsData.postValue(response.body()?.newsList)
                } else {
                    // Handle unsuccessful response
                }
            } catch (e: Exception) {
                // Handle network or other errors
            }
        }
    }
}