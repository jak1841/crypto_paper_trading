package com.example.cryptopapertradingapp.crypto.data.api.coingecko

import com.example.cryptopapertradingapp.crypto.data.database.CoinBasicInfoEntity

data class CoinGeckoBasicInfoDto(
    val id: String,
    val symbol: String,
    val name: String
)

fun CoinGeckoBasicInfoDto.toCoinBasicInfoEntity() : CoinBasicInfoEntity {
    return CoinBasicInfoEntity(
        name = name,
        id = id,
        symbol = symbol
    )
}