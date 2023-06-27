package com.example.mathapp.usecase.result

import com.example.mathapp.domain.result.ResultRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject


class InsertResultUseCase @Inject constructor(
    private val repository: ResultRepository
) {
    suspend fun invoke(result: ResultModel) {
        repository.insertResult(result)
    }
}