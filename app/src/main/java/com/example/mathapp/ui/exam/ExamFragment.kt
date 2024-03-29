package com.example.mathapp.ui.exam

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.unit.composable.UnitScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExamFragment : BaseFragment<FragmentNavBinding>() {

    val viewModel: ExamViewModel by viewModels()
    private val navController: NavController by lazy { findNavController() }


    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            UnitScreen(navController = navController, score = false , exam = true, scoreInternal = false)
        }
    }
}

