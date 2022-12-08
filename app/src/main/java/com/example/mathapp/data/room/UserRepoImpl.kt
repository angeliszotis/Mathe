package com.example.mathapp.data.room

import android.content.Context
import com.example.mathapp.data.model.UserDataModel
import com.example.mathapp.data.room.dao.UserRoomDatabase
import com.example.mathapp.data.room.dao.dbDao
import com.example.mathapp.data.room.entity.UserEntity
import com.example.mathapp.domain.UsersRepo
import com.google.firebase.firestore.Query
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
private val db : UserRoomDatabase
) : UsersRepo{
    override  suspend fun addUsers(user: UserEntity){
        db.quizDao().insertAll(user)

    }
    override suspend fun updateUsers(user:UserEntity){
        db.quizDao().updateUsers(user)
    }
    override suspend fun getUsers(): List<UserEntity> {

        return db.quizDao().getAll()

    }
}