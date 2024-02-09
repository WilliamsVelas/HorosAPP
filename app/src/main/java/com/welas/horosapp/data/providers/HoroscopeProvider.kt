package com.welas.horosapp.data.providers

import com.welas.horosapp.domain.model.HoroscopeInfo
import com.welas.horosapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Aquarius,
            Cancer,
            Scorpio,
            Gemini,
            Leo,
            Libra,
            Pisces,
            Sagittarius,
            Virgo
        )
    }
}