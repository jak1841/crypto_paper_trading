package com.example.cryptopapertradingapp.crypto.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coin_info")
data class CoinBasicInfoEntity(
    @PrimaryKey val id: String,
    val symbol: String,
    val name: String
)
