package com.example.mathapp.ui.exam

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.BaseFragment
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.exam.composable.ExamScreen

class ExamFragment : BaseFragment<FragmentNavBinding>() {


    val viewModel: ExamViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            ExamScreen()
        }
        //setupObservers()
    }
}