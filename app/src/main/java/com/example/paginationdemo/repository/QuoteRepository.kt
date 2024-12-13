package com.example.paginationdemo.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.paginationdemo.paging.QuotePagingSource
import com.example.paginationdemo.retrofit.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {
    init {
        Log.d("QuoteRepository", "Initialized with $quoteApi")
    }
    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 1, maxSize = 15),
        pagingSourceFactory = {QuotePagingSource(quoteApi)
        }
    ).liveData
}