package com.example.mathapp.data.result.unit1

import com.example.mathapp.domain.result.unit1.ResultUnit1Repository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class ResultUnit1RepositoryImpl @Inject constructor(
    private val resultUnit1DataSource: ResultUnit1DataSource
) : ResultUnit1Repository {
    override suspend fun insertResult(results: ResultModel) {
        return resultUnit1DataSource.insertResult(results)
    }
}