package com.example.mathapp.data.room.dao

import androidx.room.*
import com.example.mathapp.data.room.entity.UserEntity
import com.google.firebase.firestore.auth.User

@Dao
interface dbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg users: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Update
    fun updateUsers(vararg users: UserEntity)




}