package com.example.cryptopapertradingapp.crypto.presentation.ui.LineGraphProvider

import androidx.compose.runtime.Composable
import android.graphics.Path
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke

class AndroidCryptoLineGraphProvider: CryptoLineGraphProvider {
    @Composable
    override fun getLineGraph(prices: List<List<Double>>, color: Color) {
        LineGraph(prices, color)
    }

    @Composable
    fun LineGraph(prices: List<List<Double>>, color: Color) {
        val sortedPrices = prices.sortedBy { it[0] }

        val timestamps = sortedPrices.map { it[0] }
        val priceValues = sortedPrices.map { it[1] }

        val minTimestamp = timestamps.minOrNull() ?: 0.0
        val maxTimestamp = timestamps.maxOrNull() ?: 1.0
        val minPrice = priceValues.minOrNull() ?: 0.0
        val maxPrice = priceValues.maxOrNull() ?: 1.0

        val xScale = { timestamp: Double ->
            (timestamp - minTimestamp) / (maxTimestamp - minTimestamp)
        }
        val yScale = { price: Double ->
            1 - (price - minPrice) / (maxPrice - minPrice) // Inverted for top-down drawing
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            val points = sortedPrices.map {
                val x = xScale(it[0]) * size.width
                val y = yScale(it[1]) * size.height
                Offset(x.toFloat(), y.toFloat())
            }

            drawLineGraph(points, color)
        }
    }

    private fun DrawScope.drawLineGraph(points: List<Offset>, color: Color) {
        if (points.size < 2) return

        val path = Path().apply {
            moveTo(points.first().x, points.first().y)
            points.drop(1).forEach { point: Offset ->
                lineTo(point.x, point.y)
            }
        }

        drawPath(
            path = path.asComposePath(),
            color = color,
            style = Stroke(width = 4f)
        )
    }


}