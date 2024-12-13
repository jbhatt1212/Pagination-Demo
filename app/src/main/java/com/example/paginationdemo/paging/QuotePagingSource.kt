package com.example.paginationdemo.paging

import android.util.Log
import com.example.paginationdemo.retrofit.QuoteApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationdemo.model.Quote
import com.example.paginationdemo.model.Result


class QuotePagingSource(private val api: QuoteApi) : PagingSource<Int, Quote>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Quote> {
        return try {
            val position = params.key ?: 1
            Log.d("QuotePagingSource", "Loading page: $position")

            val response = api.getQuotes(position)

            return LoadResult.Page(
                data = response.quotes,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.total) null else position + 1
            )
        } catch (e: Exception) {
            Log.e("QuotePagingSource", "Error loading data", e)
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Quote>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

        }
    }
}