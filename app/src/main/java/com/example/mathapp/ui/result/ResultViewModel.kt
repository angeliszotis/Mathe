package com.example.mathapp.ui.result

import androidx.lifecycle.ViewModel
import com.example.mathapp.usecase.result.InsertResultUseCase
import com.example.mathapp.usecase.user.GetLastUserUseCase
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val resultUseCase: InsertResultUseCase,
    private val userUseCase: GetLastUserUseCase
) : ViewModel() {

  //  private val _insertResultStatus = MutableStateFlow<Result<Unit>>(Idle)
   // val insertResultStatus: StateFlow<Result<Unit>> = _insertResultStatus.asStateFlow()
 //ToDo: May Remove

}