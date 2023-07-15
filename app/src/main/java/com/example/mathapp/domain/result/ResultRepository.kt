package com.example.mathapp.domain.result

import com.example.mathapp.framework.result.model.ResultModel

interface ResultRepository {
    suspend fun insertResultUnit1(results: ResultModel)
    suspend fun insertResultUnit2(results: ResultModel)
    suspend fun insertResultUnit3(results: ResultModel)
    suspend fun insertResultUnit4(results: ResultModel)
    suspend fun insertResultUnit5(results: ResultModel)
    suspend fun insertResultUnit6(results: ResultModel)
    suspend fun insertResultUnit7(results: ResultModel)
    suspend fun insertResultUnit8(results: ResultModel)
}