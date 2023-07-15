package com.example.mathapp.domain.score.internal

import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import kotlinx.coroutines.flow.Flow

interface ScoreInternalRepository {
    suspend fun getScoreUnit1(): Flow<List<ResultUnit1Entity>>
    suspend fun getScoreUnit2(): Flow<List<ResultUnit2Entity>>
    suspend fun getScoreUnit3(): Flow<List<ResultUnit3Entity>>
    suspend fun getScoreUnit4(): Flow<List<ResultUnit4Entity>>
    suspend fun getScoreUnit5(): Flow<List<ResultUnit5Entity>>
    suspend fun getScoreUnit6(): Flow<List<ResultUnit6Entity>>
    suspend fun getScoreUnit7(): Flow<List<ResultUnit7Entity>>
    suspend fun getScoreUnit8(): Flow<List<ResultUnit8Entity>>


    suspend fun insertInternalScoreUnit1(result: ResultUnit1Entity)
    suspend fun insertInternalScoreUnit2(result: ResultUnit2Entity)
    suspend fun insertInternalScoreUnit3(result: ResultUnit3Entity)
    suspend fun insertInternalScoreUnit4(result: ResultUnit4Entity)
    suspend fun insertInternalScoreUnit5(result: ResultUnit5Entity)
    suspend fun insertInternalScoreUnit6(result: ResultUnit6Entity)
    suspend fun insertInternalScoreUnit7(result: ResultUnit7Entity)
    suspend fun insertInternalScoreUnit8(result: ResultUnit8Entity)
}