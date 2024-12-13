package com.example.paginationdemo.model

data class QuoteList (
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)


//val count: Int,
//val lastItemIndex: Int,
//val page: Int,
//val results: List<Result>,
//val totalCount: Int,
//val totalPages: Int