package com.example.cryptopapertradingapp.crypto.domain.model

data class CoinPriceHistory(
    val id: String,
    val daysFromNow: Int,
    val prices: List<List<Double>>,
)
