package com.example.mathapp.ui.unit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.unit.composable.UnitScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UnitFragment : BaseFragment<FragmentNavBinding>() {


    val viewModel: UnitViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            UnitScreen()
        }
        //setupObservers()
    }

}