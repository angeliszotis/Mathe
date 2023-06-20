package com.example.mathapp.framework.score.internal

import com.example.mathapp.data.score.internal.ScoreInternalDataSource
import com.example.mathapp.framework.db.RoomDb
import com.example.mathapp.framework.result.model.ResultEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ScoreInternalDataSourceImpl @Inject constructor(
    private val db: RoomDb
) : ScoreInternalDataSource {


    override suspend fun insertData(result: ResultEntity) {
        db.resultDao().insertData(result)
    }

    override suspend fun getData(): Flow<List<ResultEntity>> {
        return db.resultDao().getData()
    }
}
