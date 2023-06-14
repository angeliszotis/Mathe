package com.example.mathapp.data.result

import com.example.mathapp.domain.result.ResultRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val resultDataSource: ResultDataSource
):ResultRepository
{
    suspend override fun insertResult(results : ResultModel)  {
        return resultDataSource.insertResult(results)
    }
}