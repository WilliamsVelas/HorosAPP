package com.welas.horosapp.domain

import com.welas.horosapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}