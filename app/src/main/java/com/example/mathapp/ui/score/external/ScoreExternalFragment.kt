package com.example.mathapp.ui.score.external

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.score.ScoreViewModel
import com.example.mathapp.ui.score.external.composable.ScoreExternalScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScoreExternalFragment : BaseFragment<FragmentNavBinding>() {
    val viewModel: ScoreViewModel by viewModels()
    private val navController: NavController by lazy { findNavController() }


    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            //ScoreExternalScreen(viewModel)
            ScoreExternalScreen(viewModel = viewModel)
        }
    }
}
