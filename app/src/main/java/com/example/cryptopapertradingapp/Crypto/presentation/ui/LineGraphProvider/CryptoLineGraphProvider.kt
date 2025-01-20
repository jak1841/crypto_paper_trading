package com.example.cryptopapertradingapp.crypto.presentation.ui.LineGraphProvider

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

interface CryptoLineGraphProvider {
    @Composable
    fun getLineGraph(prices: List<List<Double>>, color: Color)
}