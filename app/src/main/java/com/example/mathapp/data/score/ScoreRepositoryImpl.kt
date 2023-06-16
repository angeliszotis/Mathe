package com.example.mathapp.data.score

import com.example.mathapp.domain.score.ScoreRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject


class ScoreRepositoryImpl @Inject constructor(
    private val scoreDataSource: ScoreDataSource
): ScoreRepository
{
    override suspend fun getScore() : List<ResultModel> {
        return scoreDataSource.getScore()
    }
}