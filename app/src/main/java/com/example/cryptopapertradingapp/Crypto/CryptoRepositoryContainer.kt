package com.example.cryptopapertradingapp.crypto

import android.content.Context
import com.example.cryptopapertradingapp.crypto.data.repository.CryptoRepositoryImpl
import com.example.cryptopapertradingapp.crypto.domain.repository.CryptoRepository

object CryptoRepositoryContainer {
    private var cryptoRepository: CryptoRepository? = null

    fun initialize(context: Context) {
        val coinInfoDao = DatabaseProvider.getDatabase(context).coinInfoDAO()
        cryptoRepository = CryptoRepositoryImpl(
            coinInfoDao,
            RetroFitClient.coinInfoApiService
        )
    }

    fun getCryptoRepository() : CryptoRepository {
        return cryptoRepository!!
    }

}