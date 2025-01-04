package com.example.cryptopapertradingapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptopapertradingapp.Crypto.RetroFitClient
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    fun printToScreen() {
        viewModelScope.launch {
            val coins = RetroFitClient.apiService.getAllCoins()
            for (coin in coins) {
                Log.d(TAG, coin.toString())
            }
        }
    }

    companion object {
        const val TAG = "HomeScreenViewModel"
    }

}