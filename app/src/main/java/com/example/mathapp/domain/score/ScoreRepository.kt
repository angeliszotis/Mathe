package com.example.mathapp.domain.score

import com.example.mathapp.framework.result.model.ResultModel

interface ScoreRepository {
    suspend fun getScore() : List<ResultModel>

}