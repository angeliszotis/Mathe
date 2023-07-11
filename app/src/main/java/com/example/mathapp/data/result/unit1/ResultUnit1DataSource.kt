package com.example.mathapp.data.result.unit1

import com.example.mathapp.framework.result.model.ResultModel


interface ResultUnit1DataSource {
    suspend fun insertResult(result: ResultModel)
}