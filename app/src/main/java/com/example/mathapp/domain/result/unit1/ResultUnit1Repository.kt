package com.example.mathapp.domain.result.unit1

import com.example.mathapp.framework.result.model.ResultModel

interface ResultUnit1Repository {
    suspend fun insertResult(results: ResultModel)
}