package com.example.mathapp.data.score.internal

import com.example.mathapp.domain.score.internal.ScoreInternalRepository
import com.example.mathapp.framework.result.model.ResultEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ScoreInternalRepositoryImpl @Inject constructor(
    private val scoreInternalDataSource: ScoreInternalDataSource
) : ScoreInternalRepository {
    override suspend fun getScore(): Flow<List<ResultEntity>> {
      return scoreInternalDataSource.getData()
    }

    override suspend fun insertUsers(result: ResultEntity) {
        scoreInternalDataSource.insertData(result)
    }

}