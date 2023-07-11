package com.example.mathapp.usecase.result.unit1

import com.example.mathapp.domain.result.unit1.ResultUnit1Repository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject


class InsertResultUnit1UseCase @Inject constructor(
    private val repository: ResultUnit1Repository
) {
    suspend fun invoke(result: ResultModel) {
        repository.insertResult(result)
    }
}