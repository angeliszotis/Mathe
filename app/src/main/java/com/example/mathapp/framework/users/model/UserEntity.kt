package com.example.mathapp.framework.users.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey
    @ColumnInfo(name = "name")
    var name: String = "name",

    @ColumnInfo(name = "surname")
    var surname: String = "surname",

    @ColumnInfo(name = "school")
    var school: String = "school",
)