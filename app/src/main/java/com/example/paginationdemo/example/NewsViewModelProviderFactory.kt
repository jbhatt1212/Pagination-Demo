package com.example.paginationdemo.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.paginationdemo.example.repository.NewsRepository

class NewsViewModelProviderFactory(
    val newsRepository: NewsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}