package com.master.exampelmvvm.data.network

import com.master.exampelmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")

suspend fun getAllQuotes(): Response<List<QuoteModel>>

}