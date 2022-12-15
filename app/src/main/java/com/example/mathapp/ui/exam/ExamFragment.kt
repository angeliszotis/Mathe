package com.example.mathapp.ui.exam

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.exam.composable.ExamScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExamFragment : BaseFragment<FragmentNavBinding>() {

    val viewModel: ExamViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            val questiosndata = viewModel.data.value

            if (questiosndata != null) {
                ExamScreen(
                    questiosndata,
                    viewModel
                )
            } else {
                Toast.makeText(requireContext(), "Check Internet Connection!", Toast.LENGTH_SHORT)
                activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }
}

