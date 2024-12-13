package com.example.paginationdemo.retrofit

import com.example.paginationdemo.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("total")page: Int
    ) : QuoteList
}