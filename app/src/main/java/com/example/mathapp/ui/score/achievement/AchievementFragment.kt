package com.example.mathapp.ui.score.achievement

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.score.ScoreViewModel
import com.example.mathapp.ui.score.achievement.composable.AchievementScreen
import dagger.hilt.android.AndroidEntryPoint

    @AndroidEntryPoint
    class AchievementFragment : BaseFragment<FragmentNavBinding>() {
        val viewModel: ScoreViewModel by viewModels()


        override fun getViewBinding(): FragmentNavBinding = FragmentNavBinding.inflate(layoutInflater)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.composeView.setContent {
                AchievementScreen()
            }
        }
    }