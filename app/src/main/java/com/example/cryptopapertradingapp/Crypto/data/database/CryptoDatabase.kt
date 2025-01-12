package com.example.cryptopapertradingapp.crypto.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CoinInfoEntity::class], version = 1, exportSchema = false)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun coinInfoDAO(): CryptoDAO
}
