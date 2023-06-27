package com.example.mathapp.data.score.external

import com.example.mathapp.framework.result.model.ResultModel

interface ScoreExternalDataSource {
    suspend fun getScore(): List<ResultModel>

}