package com.example.cryptopapertradingapp.crypto.data.repository

import com.example.cryptopapertradingapp.crypto.data.api.coingecko.CoinGeckoApiService
import com.example.cryptopapertradingapp.crypto.data.api.coingecko.toCoinBasicInfoEntity
import com.example.cryptopapertradingapp.crypto.data.api.coingecko.toCoinMarketHistory
import com.example.cryptopapertradingapp.crypto.data.database.CryptoDAO
import com.example.cryptopapertradingapp.crypto.data.database.CoinBasicInfoEntity
import com.example.cryptopapertradingapp.crypto.domain.model.CoinPriceHistory
import com.example.cryptopapertradingapp.crypto.domain.repository.CryptoRepository

class CryptoRepositoryImpl(
    private val coinInfoDAO: CryptoDAO,
    private val coinInfoAPIService: CoinGeckoApiService
): CryptoRepository {
    override suspend fun fetchAndSaveAllCoinInfos() {
        val listCoinInfo = coinInfoAPIService.getAllCoins()
        val listCoinInfoEntities = listCoinInfo.map { it.toCoinBasicInfoEntity() }
        for (coinEntity: CoinBasicInfoEntity in listCoinInfoEntities) {
            insertCoinInfo(coinEntity)
        }
    }

    override suspend fun getAllCoinInfos(): List<CoinBasicInfoEntity> {
        return coinInfoDAO.getAllCryptos()
    }

    override suspend fun getCoinInfoById(id: String): CoinBasicInfoEntity? {
       return coinInfoDAO.getCryptoById(id)
    }

    override suspend fun searchCoinInfoByName(name: String): List<CoinBasicInfoEntity> {
        return coinInfoDAO.searchCryptoByName("$name%");
    }

    override suspend fun insertCoinInfo(coinBasicInfoEntity: CoinBasicInfoEntity) {
        return coinInfoDAO.insert(coinBasicInfoEntity)
    }

    override suspend fun deleteAllCoinInfo() {
        return coinInfoDAO.deleteAll()
    }

    override suspend fun getCoinPriceHistory(
        coinId: String,
        currencyType: String,
        days: Int
    ): CoinPriceHistory {
        val coinMarketHistoryDTO = coinInfoAPIService.getCoinMarketHistory(coinId, currencyType, days)
        return coinMarketHistoryDTO.toCoinMarketHistory(id = coinId, daysFromNow = days)
    }
}