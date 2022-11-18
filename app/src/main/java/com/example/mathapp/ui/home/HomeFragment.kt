package com.example.mathapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.mathapp.BaseFragment
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.home.composable.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentNavBinding>() {

    val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            HomeScreen(viewModel = viewModel)
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