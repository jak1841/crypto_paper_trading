package com.example.cryptopapertradingapp.crypto.data.api.coingecko

import retrofit2.http.GET



interface CoinGeckoApiService {
    // Define a GET request to fetch the list of all coins
    @GET("coins/list")
    suspend fun getAllCoins(): List<CoinGeckoInfoDto>  // The response is a list of Coin objects
}