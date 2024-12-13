package com.example.paginationdemo.model

data class DataModel(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)