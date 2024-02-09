package com.welas.horosapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.welas.horosapp.R
import com.welas.horosapp.databinding.ActivityHoroscopeDetailBinding
import com.welas.horosapp.domain.model.HoroscopeModel
import com.welas.horosapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeViewModel.getHoroscope(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> detailState(it)
                    }
                }
            }
        }
    }

    private fun detailState(state: HoroscopeDetailState.Success) {
        binding.pbDetail.isVisible = false

        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Aquarius -> R.drawable.detail_aquarius
            Cancer -> R.drawable.detail_cancer
            Scorpio -> R.drawable.detail_scorpio
            Gemini -> R.drawable.detail_gemini
            Leo -> R.drawable.detail_leo
            Libra -> R.drawable.detail_libra
            Pisces -> R.drawable.detail_pisces
            Sagittarius -> R.drawable.detail_sagittarius
            Virgo -> R.drawable.detail_virgo
        }

        binding.ivDetail.setImageResource(image)
    }

    private fun errorState() {
        binding.pbDetail.isVisible = false
    }

    private fun loadingState() {
        binding.pbDetail.isVisible = true
    }
}