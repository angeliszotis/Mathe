package com.example.mathapp.data.score.internal

import com.example.mathapp.framework.result.model.ResultEntity
import kotlinx.coroutines.flow.Flow

interface ScoreInternalDataSource {
    suspend fun insertData(result: ResultEntity)
    suspend fun getData(): Flow<List<ResultEntity>>
}