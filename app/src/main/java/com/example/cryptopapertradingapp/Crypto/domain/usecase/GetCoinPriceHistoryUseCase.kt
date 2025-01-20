package com.example.cryptopapertradingapp.crypto.domain.usecase

import com.example.cryptopapertradingapp.crypto.domain.model.CoinPriceHistory
import com.example.cryptopapertradingapp.crypto.domain.repository.CryptoRepository

class GetCoinPriceHistoryUseCase(private val cryptoRepository: CryptoRepository) {
    suspend fun execute(coinId:String, currency: String, daysBefore: Int): CoinPriceHistory {
        return cryptoRepository.getCoinPriceHistory(coinId, currency, daysBefore)
    }
}