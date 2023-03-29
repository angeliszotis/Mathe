package com.example.mathapp.ui.score

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.score.composable.ScoreScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
    class ScoreFragment : BaseFragment<FragmentNavBinding>() {
        val viewModel: ScoreViewModel by viewModels()

        override fun getViewBinding(): FragmentNavBinding =
            FragmentNavBinding.inflate(layoutInflater)

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.composeView.setContent {
                ScoreScreen()
            }
        }
    }
