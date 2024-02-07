package com.welas.horosapp.domain.model

import com.welas.horosapp.R

sealed class HoroscopeInfo(val img: Int, val name: Int) {
    object Aries : HoroscopeInfo(R.drawable.aries, R.string.aries)
    object Tauro : HoroscopeInfo(R.drawable.tauro, R.string.taurus)
    object Acuario : HoroscopeInfo(R.drawable.aquario, R.string.aquarius)
    object Cancer : HoroscopeInfo(R.drawable.cancer, R.string.cancer)
    object Escorpio : HoroscopeInfo(R.drawable.escorpio, R.string.scorpio)
    object Geminis : HoroscopeInfo(R.drawable.geminis, R.string.gemini)
    object Leo : HoroscopeInfo(R.drawable.leo, R.string.leo)
    object Libra : HoroscopeInfo(R.drawable.libra, R.string.libra)
    object Piscis : HoroscopeInfo(R.drawable.piscis, R.string.pisces)
    object Sagitario : HoroscopeInfo(R.drawable.sagitario, R.string.sagittarius)
    object Virgo : HoroscopeInfo(R.drawable.virgo, R.string.virgo)

}