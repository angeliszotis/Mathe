package com.example.mathapp.ui.theory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.unit.UnitViewModel
import com.example.mathapp.ui.unit.composable.UnitScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TheoryFragment : BaseFragment<FragmentNavBinding>() {


    val viewModel: UnitViewModel by viewModels()
    private val navController: NavController by lazy { findNavController() }

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            UnitScreen(navController = navController, exam = false)
        }
    }

}