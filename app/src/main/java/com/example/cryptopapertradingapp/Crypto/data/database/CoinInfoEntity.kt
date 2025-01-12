package com.example.cryptopapertradingapp.crypto.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cryptopapertradingapp.crypto.data.api.coingecko.CoinGeckoInfoDto

@Entity(tableName = "coin_info")
data class CoinInfoEntity(
    @PrimaryKey val id: String,
    val symbol: String,
    val name: String
)
