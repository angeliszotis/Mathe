package com.example.mathapp.framework.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mathapp.framework.result.model.ResultUnit1Entity
import com.example.mathapp.framework.result.model.ResultUnit2Entity
import com.example.mathapp.framework.result.model.ResultUnit3Entity
import com.example.mathapp.framework.result.model.ResultUnit4Entity
import com.example.mathapp.framework.result.model.ResultUnit5Entity
import com.example.mathapp.framework.result.model.ResultUnit6Entity
import com.example.mathapp.framework.result.model.ResultUnit7Entity
import com.example.mathapp.framework.result.model.ResultUnit8Entity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultUnit1Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit1Entity)

    @Delete
    fun deleteData(result: ResultUnit1Entity)

    @Query("SELECT * FROM result")
    fun getData(): Flow<List<ResultUnit1Entity>>
}
@Dao
interface ResultUnit2Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit2Entity)

    @Delete
    fun deleteData(result: ResultUnit2Entity)

    @Query("SELECT * FROM unit2")
    fun getData(): Flow<List<ResultUnit2Entity>>
}
@Dao
interface ResultUnit3Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit3Entity)

    @Delete
    fun deleteData(result: ResultUnit3Entity)

    @Query("SELECT * FROM unit3")
    fun getData(): Flow<List<ResultUnit3Entity>>
}
@Dao
interface ResultUnit4Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit4Entity)

    @Delete
    fun deleteData(result: ResultUnit4Entity)

    @Query("SELECT * FROM unit4")
    fun getData(): Flow<List<ResultUnit4Entity>>
}
@Dao
interface ResultUnit5Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit5Entity)

    @Delete
    fun deleteData(result: ResultUnit5Entity)

    @Query("SELECT * FROM unit5")
    fun getData(): Flow<List<ResultUnit5Entity>>
}
@Dao
interface ResultUnit6Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit6Entity)

    @Delete
    fun deleteData(result: ResultUnit6Entity)

    @Query("SELECT * FROM unit6")
    fun getData(): Flow<List<ResultUnit6Entity>>
}
@Dao
interface ResultUnit7Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit7Entity)

    @Delete
    fun deleteData(result: ResultUnit7Entity)

    @Query("SELECT * FROM unit7")
    fun getData(): Flow<List<ResultUnit7Entity>>
}
@Dao
interface ResultUnit8Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg result: ResultUnit8Entity)

    @Delete
    fun deleteData(result: ResultUnit8Entity)

    @Query("SELECT * FROM unit8")
    fun getData(): Flow<List<ResultUnit8Entity>>
}