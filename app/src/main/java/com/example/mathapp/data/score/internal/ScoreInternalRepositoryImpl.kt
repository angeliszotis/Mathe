package com.example.mathapp.data.score.internal

import com.example.mathapp.domain.score.internal.ScoreInternalRepository
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ScoreInternalRepositoryImpl @Inject constructor(
    private val scoreInternalDataSource: ScoreInternalDataSource
) : ScoreInternalRepository {
    override suspend fun getScoreUnit1(): Flow<List<ResultUnit1Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit1()
    }

    override suspend fun getScoreUnit2(): Flow<List<ResultUnit2Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit2()
    }

    override suspend fun getScoreUnit3(): Flow<List<ResultUnit3Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit3()
    }

    override suspend fun getScoreUnit4(): Flow<List<ResultUnit4Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit4()
    }

    override suspend fun getScoreUnit5(): Flow<List<ResultUnit5Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit5()
    }

    override suspend fun getScoreUnit6(): Flow<List<ResultUnit6Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit6()
    }

    override suspend fun getScoreUnit7(): Flow<List<ResultUnit7Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit7()
    }

    override suspend fun getScoreUnit8(): Flow<List<ResultUnit8Entity>> {
        return scoreInternalDataSource.getInternalScoreUnit8()
    }

    override suspend fun insertInternalScoreUnit1(result: ResultUnit1Entity) {
        scoreInternalDataSource.insertInternalScoreUnit1(result)
    }

    override suspend fun insertInternalScoreUnit2(result: ResultUnit2Entity) {
        scoreInternalDataSource.insertInternalScoreUnit2(result)
    }

    override suspend fun insertInternalScoreUnit3(result: ResultUnit3Entity) {
        scoreInternalDataSource.insertInternalScoreUnit3(result)
    }

    override suspend fun insertInternalScoreUnit4(result: ResultUnit4Entity) {
        scoreInternalDataSource.insertInternalScoreUnit4(result)
    }

    override suspend fun insertInternalScoreUnit5(result: ResultUnit5Entity) {
        scoreInternalDataSource.insertInternalScoreUnit5(result)
    }

    override suspend fun insertInternalScoreUnit6(result: ResultUnit6Entity) {
        scoreInternalDataSource.insertInternalScoreUnit6(result)
    }

    override suspend fun insertInternalScoreUnit7(result: ResultUnit7Entity) {
        scoreInternalDataSource.insertInternalScoreUnit7(result)
    }

    override suspend fun insertInternalScoreUnit8(result: ResultUnit8Entity) {
        scoreInternalDataSource.insertInternalScoreUnit8(result)
    }

}