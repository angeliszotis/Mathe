package com.example.mathapp.ui.score.achievement

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.score.achievement.composable.AchievementScreen
import com.example.mathapp.util.achievementItems
import dagger.hilt.android.AndroidEntryPoint

    @AndroidEntryPoint
    class AchievementFragment : BaseFragment<FragmentNavBinding>() {
        val viewModel: AchievementViewModel by viewModels()

        override fun getViewBinding(): FragmentNavBinding = FragmentNavBinding.inflate(layoutInflater)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.composeView.setContent {
                AchievementScreen(viewModel = viewModel, achievements = achievementItems)
            }
        }
    }