package com.example.mathapp.usecase.result

import com.example.mathapp.domain.result.ResultRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class InsertResultUnit1UseCase @Inject constructor(
    private val repository: ResultRepository
) {
    suspend fun invoke(result: ResultModel, unit:Int) {
        when (unit) {
            1 -> repository.insertResultUnit1(result)
            2 -> repository.insertResultUnit2(result)
            3 -> repository.insertResultUnit3(result)
            4 -> repository.insertResultUnit4(result)
            5 -> repository.insertResultUnit5(result)
            6 -> repository.insertResultUnit6(result)
            7 -> repository.insertResultUnit7(result)
            8 -> repository.insertResultUnit8(result)
            else -> {}
        }
    }

}
