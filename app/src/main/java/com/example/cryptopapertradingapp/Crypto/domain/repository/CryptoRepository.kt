package com.example.cryptopapertradingapp.crypto.domain.repository

import com.example.cryptopapertradingapp.crypto.data.database.CoinBasicInfoEntity
import com.example.cryptopapertradingapp.crypto.domain.model.CoinPriceHistory

interface CryptoRepository {
    suspend fun fetchAndSaveAllCoinInfos()
    suspend fun getAllCoinInfos(): List<CoinBasicInfoEntity>
    suspend fun getCoinInfoById(id: String): CoinBasicInfoEntity?
    suspend fun searchCoinInfoByName(name: String): List<CoinBasicInfoEntity>
    suspend fun insertCoinInfo(coinBasicInfoEntity: CoinBasicInfoEntity)
    suspend fun deleteAllCoinInfo()

    suspend fun getCoinPriceHistory(coinId: String, currencyType: String, days: Int): CoinPriceHistory

}