package com.example.cryptopapertradingapp.crypto.domain.usecase

import com.example.cryptopapertradingapp.crypto.domain.repository.CryptoRepository

class GetCryptoSearchSuggestionUseCase(private val cryptoRepository: CryptoRepository) {

    suspend fun execute(searchQuery: String): List<String> {
        val suggestions = cryptoRepository.searchCoinInfoByName(searchQuery).map { it.name }
        return suggestions.take(10)
    }
}