package com.example.mathapp.framework.db.dao

import androidx.room.*
import com.example.mathapp.framework.users.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(vararg users: UserEntity)

    @Delete
    fun deleteData(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getData(): Flow<List<UserEntity>>

    @Update
    fun updateData(vararg users: UserEntity)

    @Query("SELECT * FROM users ORDER BY name DESC LIMIT 1")
    suspend fun getLastUser(): UserEntity?

}