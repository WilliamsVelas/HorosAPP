package com.welas.horosapp.data

import android.util.Log
import com.welas.horosapp.data.network.HoroscopeApiService
import com.welas.horosapp.data.network.response.PredictionResponse
import com.welas.horosapp.domain.Repository
import com.welas.horosapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching {
            apiService.getHoroscope(sign)
        }
            .onSuccess { return it.toDomain() }
            .onFailure {
                Log.i("Welaso", "Esto fallo jaja lol ${it.message}")
            }
        return null
    }

}