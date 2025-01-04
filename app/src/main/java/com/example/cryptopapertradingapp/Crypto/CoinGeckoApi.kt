package com.example.cryptopapertradingapp.Crypto

import retrofit2.http.GET

data class Coin(
    val id: String,
    val symbol: String,
    val name: String
)

interface CoinGeckoApi {
    // Define a GET request to fetch the list of all coins
    @GET("coins/list")
    suspend fun getAllCoins(): List<Coin>  // The response is a list of Coin objects
}