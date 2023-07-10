package com.example.mathapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.mathapp.usecase.user.GetUsersUseCase
import com.example.mathapp.util.NavButtonItems
import com.example.mathapp.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _ldata = SingleLiveEvent<NavDirections>()
    val ldata: LiveData<NavDirections> = _ldata

    fun onItemClicked(item: NavButtonItems) {
        _ldata.value = item.destination
    }

  fun dashboardGetExamBool(): Flow<Boolean> {
      return flow {
          val users = getUsersUseCase.invoke()
          val isNameEmpty = users.firstOrNull()?.firstOrNull()?.name?.isEmpty() ?: true
          val isNameNotEqualToDefault = !users.firstOrNull()?.firstOrNull()?.name.equals("")

          emit(isNameEmpty && isNameNotEqualToDefault)
      }
  }
}