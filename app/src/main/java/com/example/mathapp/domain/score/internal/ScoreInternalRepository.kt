package com.example.mathapp.domain.score.internal

import com.example.mathapp.framework.result.model.ResultEntity
import kotlinx.coroutines.flow.Flow

interface ScoreInternalRepository {
    suspend fun getScore(): Flow<List<ResultEntity>>
    suspend fun insertUsers(result: ResultEntity)
}