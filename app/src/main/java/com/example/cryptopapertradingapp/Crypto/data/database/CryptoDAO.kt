package com.example.cryptopapertradingapp.crypto.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(coinInfo: CoinBasicInfoEntity)

    @Query("SELECT * FROM coin_info WHERE id = :id")
    suspend fun getCryptoById(id: String): CoinBasicInfoEntity?

    @Query("SELECT * FROM coin_info")
    suspend fun getAllCryptos(): List<CoinBasicInfoEntity>

    @Query("DELETE FROM coin_info")
    suspend fun deleteAll()

    @Query("SELECT * FROM coin_info WHERE name LIKE :name")
    suspend fun searchCryptoByName(name: String): List<CoinBasicInfoEntity>
}