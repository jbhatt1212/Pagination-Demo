package com.example.paginationdemo.retrofit

import com.example.paginationdemo.repository.QuoteRepository
import com.example.paginationdemo.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {


    @Provides
    fun provideQuoteService(): QuoteApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }

    @Provides
    fun provideQuoteRepository(quoteService: QuoteApi): QuoteRepository {
        return QuoteRepository(quoteService)
    }
}