package com.example.cryptopapertradingapp.crypto.data.repository

import android.util.Log
import com.example.cryptopapertradingapp.crypto.data.api.coingecko.CoinGeckoApiService
import com.example.cryptopapertradingapp.crypto.data.api.coingecko.toCoinInfoEntity
import com.example.cryptopapertradingapp.crypto.data.database.CryptoDAO
import com.example.cryptopapertradingapp.crypto.data.database.CoinInfoEntity
import com.example.cryptopapertradingapp.crypto.domain.repository.CryptoRepository

class CryptoRepositoryImpl(
    private val coinInfoDAO: CryptoDAO,
    private val coinInfoAPIService: CoinGeckoApiService
): CryptoRepository {
    override suspend fun fetchAndSaveAllCoinInfos() {
        val listCoinInfo = coinInfoAPIService.getAllCoins()
        val listCoinInfoEntities = listCoinInfo.map { it.toCoinInfoEntity() }
        for (coinEntity: CoinInfoEntity in listCoinInfoEntities) {
            insertCoinInfo(coinEntity)
        }
    }

    override suspend fun getAllCoinInfos(): List<CoinInfoEntity> {
        return coinInfoDAO.getAllCryptos()
    }

    override suspend fun getCoinInfoById(id: String): CoinInfoEntity? {
       return coinInfoDAO.getCryptoById(id)
    }

    override suspend fun searchCoinInfoByName(name: String): List<CoinInfoEntity> {
        return coinInfoDAO.searchCryptoByName("$name%");
    }

    override suspend fun insertCoinInfo(coinInfoEntity: CoinInfoEntity) {
        return coinInfoDAO.insert(coinInfoEntity)
    }

    override suspend fun deleteAllCoinInfo() {
        return coinInfoDAO.deleteAll()
    }
}