package com.example.mathapp.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.BaseFragment
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.profile.composable.ProfileScreen
import com.example.mathapp.ui.theory.TheoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentNavBinding>() {


    val viewModel: TheoryViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            ProfileScreen()
        }
        //setupObservers()
    }

}
