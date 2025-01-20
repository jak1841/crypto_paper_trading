package com.example.cryptopapertradingapp.crypto.data.api.coingecko

import com.example.cryptopapertradingapp.crypto.domain.model.CoinPriceHistory

data class CoinGeckoCoinPriceHistoryDTO(
    val prices: List<List<Double>>,
)

fun CoinGeckoCoinPriceHistoryDTO.toCoinMarketHistory(id: String, daysFromNow: Int): CoinPriceHistory {
   return CoinPriceHistory(
       id = id,
       daysFromNow = daysFromNow,
       prices = prices,
   )
}