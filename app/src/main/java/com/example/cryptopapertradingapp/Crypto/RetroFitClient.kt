package com.example.cryptopapertradingapp.Crypto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {
    private const val BASE_URL = "https://api.coingecko.com/api/v3/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Set the base URL for the API
            .addConverterFactory(GsonConverterFactory.create())  // Gson converter for JSON parsing
            .build()
    }

    val apiService: CoinGeckoApi by lazy {
        retrofit.create(CoinGeckoApi::class.java)
    }
}