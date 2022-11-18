package com.example.mathapp.data.room.dao

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface dbDao {

    @Insert
    suspend fun insert(data: List<String>)


}