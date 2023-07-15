package com.example.mathapp.framework.users.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,

    @ColumnInfo(name = "name")
    var name: String = "name",

    @ColumnInfo(name = "surname")
    var surname: String = "surname",

    @ColumnInfo(name = "school")
    var school: String = "school",
)