package com.example.mathapp.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mathapp.data.room.entity.UserEntity
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.profile.composable.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentNavBinding>() {


    val viewModel: ProfileViewModel by viewModels()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            ProfileScreen(viewModel)
        }

        viewModel.addUser(setUDM(viewModel, "", "", ""))

        viewModel.getUser()
    }

}

fun setUDM(viewModel: ProfileViewModel, name: String, surname: String, school: String): UserEntity {

    var list = UserEntity(name, surname, school)
    viewModel.addUser(list)

    return list
}
