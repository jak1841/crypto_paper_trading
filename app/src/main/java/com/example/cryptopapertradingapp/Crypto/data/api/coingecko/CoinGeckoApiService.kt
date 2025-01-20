package com.example.cryptopapertradingapp.crypto.data.api.coingecko

import retrofit2.http.Query
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinGeckoApiService {
    @GET("coins/list")
    suspend fun getAllCoins(): List<CoinGeckoBasicInfoDto>  // The response is a list of Coin objects

    @GET("coins/{id}/market_chart")
    suspend fun getCoinMarketHistory(
        @Path("id") coinId: String,
        @Query("vs_currency") currency: String,
        @Query("days") days: Int
    ): CoinGeckoCoinPriceHistoryDTO

}