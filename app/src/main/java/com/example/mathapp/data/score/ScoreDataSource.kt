package com.example.mathapp.data.score

import com.example.mathapp.framework.result.model.ResultModel

interface ScoreDataSource {
    suspend fun getScore() : List<ResultModel>

}