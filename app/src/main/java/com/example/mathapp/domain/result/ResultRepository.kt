package com.example.mathapp.domain.result

import com.example.mathapp.framework.result.model.ResultModel

interface ResultRepository {
    suspend fun insertResult(results: ResultModel)
}