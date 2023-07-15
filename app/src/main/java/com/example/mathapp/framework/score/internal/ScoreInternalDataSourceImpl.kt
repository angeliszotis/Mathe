package com.example.mathapp.framework.score.internal

import com.example.mathapp.data.score.internal.ScoreInternalDataSource
import com.example.mathapp.framework.db.RoomDb
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

class ScoreInternalDataSourceImpl @Inject constructor(
    private val db: RoomDb
) : ScoreInternalDataSource {

    override suspend fun getInternalScoreUnit1(): Flow<List<ResultUnit1Entity>> {
        return db.resultUnit1Dao().getData()
    }

    override suspend fun getInternalScoreUnit2(): Flow<List<ResultUnit2Entity>> {
        return db.resultUnit2Dao().getData()
    }

    override suspend fun getInternalScoreUnit3(): Flow<List<ResultUnit3Entity>> {
        return db.resultUnit3Dao().getData()
    }

    override suspend fun getInternalScoreUnit4(): Flow<List<ResultUnit4Entity>> {
        return db.resultUnit4Dao().getData()
    }

    override suspend fun getInternalScoreUnit5(): Flow<List<ResultUnit5Entity>> {
        return db.resultUnit5Dao().getData()
    }

    override suspend fun getInternalScoreUnit6(): Flow<List<ResultUnit6Entity>> {
        return db.resultUnit6Dao().getData()
    }

    override suspend fun getInternalScoreUnit7(): Flow<List<ResultUnit7Entity>> {
        return db.resultUnit7Dao().getData()
    }

    override suspend fun getInternalScoreUnit8(): Flow<List<ResultUnit8Entity>> {
        return db.resultUnit8Dao().getData()
    }

    //Insert
    override suspend fun insertInternalScoreUnit1(result: ResultUnit1Entity) {
        db.resultUnit1Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit2(result: ResultUnit2Entity) {
        db.resultUnit2Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit3(result: ResultUnit3Entity) {
        db.resultUnit3Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit4(result: ResultUnit4Entity) {
        db.resultUnit4Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit5(result: ResultUnit5Entity) {
        db.resultUnit5Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit6(result: ResultUnit6Entity) {
        db.resultUnit6Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit7(result: ResultUnit7Entity) {
        db.resultUnit7Dao().insertData(result)
    }

    override suspend fun insertInternalScoreUnit8(result: ResultUnit8Entity) {
        db.resultUnit8Dao().insertData(result)
    }
}
