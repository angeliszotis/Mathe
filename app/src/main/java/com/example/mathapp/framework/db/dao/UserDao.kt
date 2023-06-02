package com.example.mathapp.framework.db.dao

import androidx.room.*
import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface dbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getAll(): Flow<List<UserEntity>>

    @Update
    fun updateUsers(vararg users: UserEntity)


}