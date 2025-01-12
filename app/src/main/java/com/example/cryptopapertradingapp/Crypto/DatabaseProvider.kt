package com.example.cryptopapertradingapp.crypto

import android.content.Context
import androidx.room.Room
import com.example.cryptopapertradingapp.crypto.data.database.CryptoDatabase

object DatabaseProvider {
    @Volatile
    private var INSTANCE: CryptoDatabase? = null

    fun getDatabase(context: Context): CryptoDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                CryptoDatabase::class.java,
                "crypto_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
