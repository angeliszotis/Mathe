package com.example.mathapp.framework.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow


interface resultDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg users: UserEntity)

    @Delete
    fun deleteData(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getData(): Flow<List<UserEntity>>

}