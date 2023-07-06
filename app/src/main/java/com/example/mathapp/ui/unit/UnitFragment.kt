package com.example.mathapp.ui.unit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.unit.composable.UnitScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UnitFragment : BaseFragment<FragmentNavBinding>() {


    val viewModel: UnitViewModel by viewModels()
    private val navController: NavController by lazy { findNavController() }
    private val args: UnitFragmentArgs by navArgs()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            UnitScreen(navController = navController, exam = false, score = args.score)
        }
        setupObservers()
    }

    private fun setupObservers() {
        with(viewModel) {
            ldata.observe(viewLifecycleOwner, Observer(::navigate))
        }
    }

    private fun navigate(destination: NavDirections) {
        findNavController().navigate(destination)
    }

}