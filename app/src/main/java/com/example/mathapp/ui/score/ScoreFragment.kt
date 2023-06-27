package com.example.mathapp.ui.score

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.score.composables.ScoreScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ScoreFragment : BaseFragment<FragmentNavBinding>() {
    val viewModel: ScoreViewModel by viewModels()
    private val navController: NavController by lazy { findNavController() }


    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            //ScoreExternalScreen(viewModel)
            ScoreScreen(viewModel = viewModel, navController = navController)
        }
    }
}
