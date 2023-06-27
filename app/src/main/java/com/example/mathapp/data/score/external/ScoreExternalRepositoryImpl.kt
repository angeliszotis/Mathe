package com.example.mathapp.data.score.external

import com.example.mathapp.domain.score.external.ScoreExternalRepository
import com.example.mathapp.framework.result.model.ResultModel
import javax.inject.Inject


class ScoreExternalRepositoryImpl @Inject constructor(
    private val scoreExternalDataSource: ScoreExternalDataSource
) : ScoreExternalRepository {
    override suspend fun getScore(): List<ResultModel> {
        return scoreExternalDataSource.getScore()
    }
}