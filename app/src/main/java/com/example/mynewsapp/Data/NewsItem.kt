package com.example.mynewsapp.Data

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("sources")
    val newsList: List<NewsItem>
)

data class NewsItem(
    @SerializedName("name")
    val title: String,
    @SerializedName("description")
    val desc: String,
    @SerializedName("category")
    val category: String
)