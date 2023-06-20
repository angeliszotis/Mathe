package com.example.mathapp.framework.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mathapp.framework.result.model.ResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface resultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultEntity)

    @Delete
    fun deleteData(result: ResultEntity)

    @Query("SELECT * FROM result")
    fun getData(): Flow<List<ResultEntity>>
}