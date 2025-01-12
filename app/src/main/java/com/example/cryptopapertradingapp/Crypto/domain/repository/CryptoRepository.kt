package com.example.cryptopapertradingapp.crypto.domain.repository

import com.example.cryptopapertradingapp.crypto.data.database.CoinInfoEntity

interface CryptoRepository {
    suspend fun fetchAndSaveAllCoinInfos()
    suspend fun getAllCoinInfos(): List<CoinInfoEntity>
    suspend fun getCoinInfoById(id: String): CoinInfoEntity?
    suspend fun searchCoinInfoByName(name: String): List<CoinInfoEntity>
    suspend fun insertCoinInfo(coinInfoEntity: CoinInfoEntity)
    suspend fun deleteAllCoinInfo()
}