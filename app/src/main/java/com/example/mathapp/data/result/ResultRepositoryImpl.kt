package com.example.mathapp.data.result

import com.example.mathapp.domain.result.ResultRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val resultDataSource: ResultDataSource
) : ResultRepository {
    override suspend fun insertResultUnit1(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit2(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit3(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit4(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit5(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit6(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit7(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }

    override suspend fun insertResultUnit8(results: ResultModel) {
        return resultDataSource.insertResultUnit1(results)
    }
}