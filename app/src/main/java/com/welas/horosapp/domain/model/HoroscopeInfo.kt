package com.welas.horosapp.domain.model

import com.welas.horosapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int) {
    data object Aries : HoroscopeInfo(R.drawable.aries, R.string.aries)
    data object Tauro : HoroscopeInfo(R.drawable.tauro, R.string.taurus)
    data object Acuario : HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    data object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    data object Escorpio : HoroscopeInfo(R.drawable.escorpio, R.string.scorpio)
    data object Geminis : HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    data object Leo : HoroscopeInfo(R.drawable.leo, R.string.leo)
    data object Libra : HoroscopeInfo(R.drawable.libra, R.string.libra)
    data object Piscis : HoroscopeInfo(R.drawable.piscis, R.string.pisces)
    data object Sagitario : HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius)
    data object Virgo : HoroscopeInfo(R.drawable.virgo, R.string.virgo)

}