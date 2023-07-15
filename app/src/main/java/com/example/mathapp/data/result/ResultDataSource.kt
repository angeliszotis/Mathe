package com.example.mathapp.data.result

import com.example.mathapp.framework.result.model.ResultModel


interface ResultDataSource {
    suspend fun insertResultUnit1(result: ResultModel)
    suspend fun insertResultUnit2(result: ResultModel)
    suspend fun insertResultUnit3(result: ResultModel)
    suspend fun insertResultUnit4(result: ResultModel)
    suspend fun insertResultUnit5(result: ResultModel)
    suspend fun insertResultUnit6(result: ResultModel)
    suspend fun insertResultUnit7(result: ResultModel)
    suspend fun insertResultUnit8(result: ResultModel)
}