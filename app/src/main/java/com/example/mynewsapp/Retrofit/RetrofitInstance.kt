package com.example.mynewsapp.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    //singleton to prevent memory leaks
    companion object{
        val BASE_URL = "https://saurav.tech/"

        fun getRetrofitInstance() : Retrofit{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }
    }
}