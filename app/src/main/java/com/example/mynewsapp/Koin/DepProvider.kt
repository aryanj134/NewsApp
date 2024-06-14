package com.example.mynewsapp.Koin

import com.example.mynewsapp.Interface.NewsService
import com.example.mynewsapp.ViewModel.NewsViewModel
import com.example.mynewsapp.Repository.NewsRepository
import com.example.mynewsapp.Retrofit.RetrofitInstance
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val provideModule = module {
    single { RetrofitInstance.getRetrofitInstance().create(NewsService::class.java) }
    single { NewsRepository(get()) }
    viewModel { NewsViewModel(get()) }
}
