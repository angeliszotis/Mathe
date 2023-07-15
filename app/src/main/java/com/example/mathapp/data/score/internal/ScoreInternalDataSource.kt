package com.example.mathapp.data.score.internal

import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import kotlinx.coroutines.flow.Flow

interface ScoreInternalDataSource {

    suspend fun getInternalScoreUnit1(): Flow<List<ResultUnit1Entity>>
    suspend fun getInternalScoreUnit2(): Flow<List<ResultUnit2Entity>>
    suspend fun getInternalScoreUnit3(): Flow<List<ResultUnit3Entity>>
    suspend fun getInternalScoreUnit4(): Flow<List<ResultUnit4Entity>>
    suspend fun getInternalScoreUnit5(): Flow<List<ResultUnit5Entity>>
    suspend fun getInternalScoreUnit6(): Flow<List<ResultUnit6Entity>>
    suspend fun getInternalScoreUnit7(): Flow<List<ResultUnit7Entity>>
    suspend fun getInternalScoreUnit8(): Flow<List<ResultUnit8Entity>>

    suspend fun insertInternalScoreUnit1(result: ResultUnit1Entity)
    suspend fun insertInternalScoreUnit2(result: ResultUnit2Entity)
    suspend fun insertInternalScoreUnit3(result: ResultUnit3Entity)
    suspend fun insertInternalScoreUnit4(result: ResultUnit4Entity)
    suspend fun insertInternalScoreUnit5(result: ResultUnit5Entity)
    suspend fun insertInternalScoreUnit6(result: ResultUnit6Entity)
    suspend fun insertInternalScoreUnit7(result: ResultUnit7Entity)
    suspend fun insertInternalScoreUnit8(result: ResultUnit8Entity)
}