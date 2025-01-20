package com.example.cryptopapertradingapp.crypto.domain.model

data class CoinAdvancedInfo(
    val name: String,
    val id: String,
    val image: String,
    val low_24h: Double,
    val high_24h: Double,
    val symbol: String,
    val price_change_24h: Double,
    val market_cap: Long,
    val current_price: Double,
)
