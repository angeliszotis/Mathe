package com.example.mathapp.domain.score.external

import com.example.mathapp.framework.result.model.ResultModel

interface ScoreExternalRepository {
    suspend fun getScore(unit:Int): List<ResultModel>
}