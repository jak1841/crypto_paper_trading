package com.example.cryptopapertradingapp

import android.app.Application
import com.example.cryptopapertradingapp.crypto.CryptoRepositoryContainer

class MyApplication : Application() {
    override fun onCreate() {
        initializeCrypto()
        super.onCreate()
    }

    private fun initializeCrypto() {
        CryptoRepositoryContainer.initialize(this)
    }
}