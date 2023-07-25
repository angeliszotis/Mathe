package com.example.mathapp.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.chat.composable.ChatScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<FragmentNavBinding>() {
    private val viewModel: ChatViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            ChatScreen(viewModel)
        }
    }
}