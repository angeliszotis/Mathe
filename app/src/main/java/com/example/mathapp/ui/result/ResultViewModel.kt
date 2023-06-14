package com.example.mathapp.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathapp.framework.result.model.ResultModel
import com.example.mathapp.usecase.result.InsertResultUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val resultUseCase: InsertResultUseCase
) : ViewModel() {

  //  private val _insertResultStatus = MutableStateFlow<Result<Unit>>(Idle)
   // val insertResultStatus: StateFlow<Result<Unit>> = _insertResultStatus.asStateFlow()
 //ToDo: May Remove
    fun insertResult(result: ResultModel) {
        viewModelScope.launch {
            try {
                resultUseCase.invoke(result)
            } catch (e: Exception) {
                //Toast.makeText(this@ResultViewModel ,"error", Toast.LENGTH_LONG).show() //
            }
        }
    }


}