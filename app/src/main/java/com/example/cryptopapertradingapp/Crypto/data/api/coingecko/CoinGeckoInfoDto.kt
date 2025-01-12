package com.example.cryptopapertradingapp.crypto.data.api.coingecko

import com.example.cryptopapertradingapp.crypto.data.database.CoinInfoEntity

data class CoinGeckoInfoDto(
    val id: String,
    val symbol: String,
    val name: String
)

fun CoinGeckoInfoDto.toCoinInfoEntity() : CoinInfoEntity {
    return CoinInfoEntity(
        name = name,
        id = id,
        symbol = symbol
    )
}