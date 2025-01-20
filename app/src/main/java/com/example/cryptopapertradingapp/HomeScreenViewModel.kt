package com.example.cryptopapertradingapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptopapertradingapp.crypto.CryptoRepositoryContainer
import com.example.cryptopapertradingapp.crypto.domain.usecase.GetCoinPriceHistoryUseCase
import com.example.cryptopapertradingapp.crypto.domain.usecase.GetCryptoSearchSuggestionUseCase
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val cryptoRepository by lazy { CryptoRepositoryContainer.getCryptoRepository() }
    private val _cryptoSearchSuggestions = MutableLiveData<List<String>>()
    val cryptoSearchSuggestions: LiveData<List<String>> get() = _cryptoSearchSuggestions


    private val _cryptoMarketHistory = MutableLiveData<List<List<Double>>>()
    val cryptMarketHistory: LiveData<List<List<Double>>> get() = _cryptoMarketHistory

    fun updateSearchSuggestion(searchQuery: String) {
        if (searchQuery == EMPTY_VALUE) {
            _cryptoSearchSuggestions.value = emptyList()
            return
        }
        val useCase = GetCryptoSearchSuggestionUseCase(cryptoRepository)
        viewModelScope.launch {
            _cryptoSearchSuggestions.value = useCase.execute(searchQuery)
        }
    }

    fun updateCryptoMarketHistory(coinId: String, currency: String, daysBefore: Int) {
        val useCase = GetCoinPriceHistoryUseCase(cryptoRepository)
        viewModelScope.launch {
            _cryptoMarketHistory.value = useCase.execute(coinId, currency, daysBefore).prices
        }
    }


    fun printToScreen() {
        Log.d(TAG, "printing the items to the screen")
        viewModelScope.launch {
            cryptoRepository.fetchAndSaveAllCoinInfos()
            val coins = cryptoRepository.getAllCoinInfos()
            for (coin in coins) {
                Log.d(TAG, coin.toString())
            }
        }
    }

    companion object {
        const val TAG = "HomeScreenViewModel"
        const val EMPTY_VALUE = ""
    }

}